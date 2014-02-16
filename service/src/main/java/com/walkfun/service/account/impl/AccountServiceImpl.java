package com.walkfun.service.account.impl;

import com.walkfun.common.exception.*;
import com.walkfun.common.lib.Callable;
import com.walkfun.common.lib.Universe;
import com.walkfun.db.account.dao.def.AccountDAO;
import com.walkfun.service.Cache.CacheFacade;
import com.walkfun.service.account.def.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import com.walkfun.entity.account.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/6/13
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

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
            checkUserExisting(userFriend.getUserId(), null);
            checkUserExisting(userFriend.getFriendId(), null);
            accountDAO.createOrUpdateUserFriend(userFriend);
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
            accountDAO.createUserAction(userAction);
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
    public List<SearchUserInfo> searchAccountInfoByName(String nickName) {
        try {
            return accountDAO.searchAccountInfoByName(nickName);
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
