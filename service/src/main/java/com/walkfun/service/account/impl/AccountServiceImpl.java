package com.walkfun.service.account.impl;

import com.walkfun.common.exception.*;
import com.walkfun.common.lib.*;
import com.walkfun.db.account.dao.def.AccountDAO;
import com.walkfun.entity.common.ActionDefinition;
import com.walkfun.entity.common.ExperienceDefinition;
import com.walkfun.entity.enums.FollowStatusEnum;
import com.walkfun.service.BaseService;
import com.walkfun.service.Cache.CacheFacade;
import com.walkfun.service.account.def.AccountService;
import com.walkfun.service.backend.BackendJobCache;
import com.walkfun.service.common.def.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

import com.walkfun.entity.account.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/6/13
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccountServiceImpl extends BaseService implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private CommonService commonService;

    @Autowired
    IOSMessageSend iosMessageSend;

    @Override
    public void checkUserLoginStatus(Integer userId) {
        try {
            if (userId > 0) {
                UserInfo userInfo = checkUserExisting(userId, null);
                if (userInfo == null || userInfo.getUserId() != Universe.current().getUserId()) {
                    throw new ServerRequestException(ErrorMessageMapper.LOGIN_CHECK_FAIL.toString());
                }
                if (!userInfo.getUuid().equalsIgnoreCase(Universe.current().getUuid())) {
                    throw new ServerRequestException(ErrorMessageMapper.LOGIN_CHECK_FAIL.toString());
                }
            } else {
                throw new ServerRequestException(ErrorMessageMapper.LOGIN_CHECK_FAIL.toString());
            }
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public UserInfo checkUserLevel(UserInfo userInfo) {
        for (ExperienceDefinition experienceDefinition : BackendJobCache.allExperience) {
            if (userInfo.getExperience() < experienceDefinition.getTotalExperience()) {
                userInfo.setLevel(experienceDefinition.getLevel());
                userInfo.setUserTitle(experienceDefinition.getTitle());
                userInfo.setUserTitlePic(experienceDefinition.getTitlePic());
                userInfo.setGoldCoinSpeed(experienceDefinition.getGoldCoinSpeed());
                userInfo.setExperienceSpeed(experienceDefinition.getExperienceSpeed());
                break;
            }
        }
        return userInfo;
    }

    private UserInfo checkUserExisting(final Integer userId, final Date lastUpdateTime) {
        String key = "user.id." + userId.toString();
        UserInfo userInfo = CacheFacade.USER.get(key, new Callable<UserInfo>() {
            @Override
            public UserInfo execute() {
                UserInfo userInfo = accountDAO.getAccountInfoByID(userId, null);
                return userInfo;
            }
        });

        if (userInfo == null || userInfo.getUserId() == null) {
            throw new ServerRequestException(ErrorMessageMapper.USER_NOT_FOUND.toString());
        }

        if (lastUpdateTime != null) {
            if (userInfo.getUpdateTime().before(lastUpdateTime)) {
                return null;
            }
        }

        return userInfo;
    }

    @Override
    public UserInfo getAccountInfo(String userEmail, String password) {
        try {
            UserInfo userInfo = accountDAO.getAccountInfo(userEmail, password);
            if (userInfo == null || userInfo.getUserId() == null) {
                throw new ServerRequestException(ErrorMessageMapper.USER_NOT_FOUND.toString());
            }
            String key = "user.id." + userInfo.getUserId().toString();
            CacheFacade.USER.evict(key);
            return userInfo;
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public UserInfo createAccountInfo(UserBase userBase) {
        try {
            UserInfo userInfo = accountDAO.getAccountInfoByName(userBase.getUserName());
            if (userInfo != null && userInfo.getUserId() != null) {
                throw new ServerRequestException(ErrorMessageMapper.USER_ALREADY_EXISTS.toString());
            }
            Integer userId = accountDAO.createAccountInfo(userBase);
            return checkUserExisting(userId, null);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void updateAccountInfo(UserInfo userInfo) {
        try {
            String key = "user.id." + userInfo.getUserId().toString();
            checkUserExisting(userInfo.getUserId(), null);
            accountDAO.updateAccountInfo(userInfo);
            CacheFacade.USER.evict(key);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void updateAccountBase(UserBase userBase) {
        try {
            String key = "user.id." + userBase.getUserId().toString();
            checkUserExisting(userBase.getUserId(), null);
            accountDAO.updateAccountBase(userBase);
            CacheFacade.USER.evict(key);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void createOrUpdateUserFriend(UserFriend userFriend) {
        try {
            UserInfo me = checkUserExisting(userFriend.getUserId(), null);
            UserInfo friend = checkUserExisting(userFriend.getFriendId(), null);
            accountDAO.createOrUpdateUserFriend(userFriend);
            if (userFriend.getFriendStatus() == FollowStatusEnum.FOLLOWED.ordinal()) {
                String token = CommonUtils.getDeviceId(friend.getDeviceId());
                if (token != null) {
                    iosMessageSend.send(token, me.getNickName() + "加你为好友了，快去好友列表看看吧！");
                }
            }
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<UserFriend> getUserFriends(Integer userId, Date lastUpdateTime) {
        try {
            return accountDAO.getUserFriends(userId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void createUserAction(UserAction userAction) {
        try {
            //1. get action definition
            ActionDefinition actionDefinition = commonService.getActionDefineById(userAction.getActionId());
            //2. get user info
            UserInfo toUser = checkUserExisting(userAction.getActionToId(), null);
            //3. explain action and effective
            Map<Integer, Integer> vProductIds = explainActionRule(actionDefinition.getActionRule());
            Map<String, Integer> userStatusMap = explainActionEffectiveRule(actionDefinition.getEffectiveRule());
            //4. add effective into user
            List<UserProp> updateProps = getUserProps(userAction.getActionFromId(), null);
            updateProps = calculateUserProp(userAction.getActionFromId(), updateProps, vProductIds);
            UserInfo updateUserInfo = calculateUserInfo(toUser, userStatusMap, vProductIds);
            //5. update database
            accountDAO.createUserAction(userAction);
            this.createOrUpdateUserProp(updateProps);
            this.updateAccountInfo(updateUserInfo);
            if (userAction.getActionFromId() != userAction.getActionToId()) {
                String token = CommonUtils.getDeviceId(toUser.getDeviceId());
                if (token != null) {
                    iosMessageSend.send(token, userAction.getActionFromName() + actionDefinition.getNotificationMessage());
                }
            }
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<UserAction> getNewlyUserAction(Integer userId) {
        try {
            return accountDAO.getNewlyUserAction(userId);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<UserAction> getUserActionById(Integer userId) {
        try {
            return accountDAO.getUserActionById(userId);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<SearchUserInfo> searchAccountInfoByName(String nickName) {
        try {
            return accountDAO.searchAccountInfoByName(nickName);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<SearchUserInfo> getRecommendFriend() {
        try {
            return accountDAO.getRecommendFriend();
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<SearchUserInfo> getRecommendFriendForRest(Integer pageNo) {
        try {
            List<SearchUserInfo> recommendUsers = new ArrayList<SearchUserInfo>();
            if (pageNo == null) {
                pageNo = 0;
            }
            for (int i = pageNo * 10; i < pageNo * 10 + 10; i++) {
                if (i < BackendJobCache.allRecommendUsers.size()) {
                    recommendUsers.add(BackendJobCache.allRecommendUsers.get(i));
                }
            }
            return recommendUsers;
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<FriendSortInfo> getFriendSort(Integer userId, Date lastUpdateTime) {
        try {
            return accountDAO.getFriendSort(userId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<UserProp> getUserProps(Integer userId, Date lastUpdateTime) {
        try {
            return accountDAO.getUserProps(userId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void createOrUpdateUserProp(List<UserProp> userProps) {
        try {
            for (UserProp userProp : userProps) {
                accountDAO.createOrUpdateUserProp(userProp);
            }
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public RewardDetails getRandomReward(Integer userId) {
        try {
            UserInfo userInfo = checkUserExisting(userId, null);
            List<UserProp> userProps = getUserProps(userId, null);
            RewardDetails rewardDetails = new RewardDetails();
            rewardDetails.setUserId(userId);
            rewardDetails.setActionId(200);
            Random random = new Random(new Date().getTime());
            List<ActionDefinition> rewardActions = commonService.getRewardActionDefine();
            for (ActionDefinition actionDefinition : rewardActions) {
                int randomNum = random.nextInt(100);
                if (randomNum < actionDefinition.getTriggerProbability() * 100) {
                    rewardDetails.setActionId(actionDefinition.getActionId());
                    break;
                }
            }
            ActionDefinition randomActionDefinition = commonService.getActionDefineById(rewardDetails.getActionId());
            Map<Integer, Integer> vProductIds = explainActionRule(randomActionDefinition.getActionRule());
            Map<String, Integer> userStatusMap = explainActionEffectiveRule(randomActionDefinition.getEffectiveRule());
            userProps = calculateUserProp(userId, userProps, vProductIds);
            userInfo = calculateUserInfo(userInfo, userStatusMap);
            for (Integer key : vProductIds.keySet()) {
                rewardDetails.setRewardPropId(vProductIds.get(key));
            }
            for (String key : userStatusMap.keySet()) {
                if (key.equalsIgnoreCase(MONEY)) {
                    rewardDetails.setRewardMoney(userStatusMap.get(key));
                }
            }
            if (rewardDetails.getRewardPropId() != null) {
                this.createOrUpdateUserProp(userProps);
            }
            if (rewardDetails.getRewardMoney() != null) {
                this.updateAccountInfo(userInfo);
            }
            return rewardDetails;
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public UserInfo getAccountInfoByID(Integer userId, Date lastUpdateTime) {
        try {
            if (userId == Universe.current().getUserId()) {
                checkUserLoginStatus(userId);
            }
            return checkUserExisting(userId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }
}
