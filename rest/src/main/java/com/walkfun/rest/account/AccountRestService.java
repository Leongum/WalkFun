package com.walkfun.rest.account;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.entity.account.*;
import com.walkfun.service.account.def.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;


/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/7/13
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountRestService implements AccountRestDef {

    @Autowired
    private AccountService accountService;

    @Override
    public UserInfo getAccountInfo(String userEmail, String password) {
        UserInfo userInfo = accountService.getAccountInfo(userEmail, password);
        userInfo.setUuid(UUID.randomUUID().toString());
        UserBase userBase = new UserBase();
        userBase = userBase.initUserBase(userInfo);
        accountService.updateAccountBase(userBase);
        return userInfo;
    }

    @Override
    public UserInfo getAccountInfoByID(String userId, String lastUpdateTime) {
        UserInfo userInfo = accountService.getAccountInfoByID(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
        return userInfo;
    }

    @Override
    public UserInfo createAccountInfo(UserBase userBase) {
        userBase.setUuid(UUID.randomUUID().toString());
        UserInfo userInfo = accountService.createAccountInfo(userBase);
        return userInfo;
    }

    @Override
    public void updateAccountBase(String userId, UserBase userBase) {
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userBase.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.updateAccountBase(userBase);
    }

    @Override
    public void updateAccountInfo(String userId, UserInfo userInfo) {
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userInfo.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.updateAccountInfo(userInfo);
    }

    @Override
    public void createOrUpdateUserFriend(String userId, UserFriend userFriend) {
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userFriend.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.createOrUpdateUserFriend(userFriend);
    }

    @Override
    public List<UserFriend> getUserFriends(String userId, String lastUpdateTime) {
        return accountService.getUserFriends(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public List<SearchUserInfo> getRecommendFriends(String pageNo) {
        return accountService.getRecommendFriendForRest(CommonUtils.parseIntegerToNull(pageNo));
    }

    @Override
    public void createUserAction(String userId, UserAction userAction) {
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userAction.setActionFromId(CommonUtils.parseIntegerToNull(userId));
        accountService.createUserAction(userAction);
    }

    @Override
    public List<UserAction> getNewlyUserAction(String userId) {
        return accountService.getNewlyUserAction(CommonUtils.parseIntegerToNull(userId));
    }

    @Override
    public List<SearchUserInfo> searchAccountInfoByName(String nickName) {
        return accountService.searchAccountInfoByName(nickName);
    }

    @Override
    public List<FriendSortInfo> getFriendSort(String userId, String lastUpdateTime) {
        return accountService.getFriendSort(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public List<UserProp> getUserProps(String userId, String lastUpdateTime) {
        return accountService.getUserProps(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createOrUpdateUserProp(String userId, List<UserProp> userProps) {
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        for (UserProp userProp : userProps) {
            userProp.setUserId(CommonUtils.parseIntegerToNull(userId));
        }
        accountService.createOrUpdateUserProp(userProps);
    }
}
