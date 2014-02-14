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
        CommonUtils.newMethodCall("User Login");
        UserInfo userInfo = accountService.getAccountInfo(userEmail, password);
        userInfo.setUuid(UUID.randomUUID().toString());
        UserBase userBase = new UserBase();
        userBase = userBase.initUserBase(userInfo);
        accountService.updateAccountBase(userBase);
        return userInfo;
    }

    @Override
    public UserInfo getAccountInfoByID(String userId, String lastUpdateTime) {
        CommonUtils.newMethodCall("Get User Info");
        UserInfo userInfo = accountService.getAccountInfoByID(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
        return userInfo;
    }

    @Override
    public UserInfo createAccountInfo(UserBase userBase) {
        CommonUtils.newMethodCall("Create User");
        userBase.setUuid(UUID.randomUUID().toString());
        UserInfo userInfo = accountService.createAccountInfo(userBase);
        return userInfo;
    }

    @Override
    public void updateAccountBase(String userId, UserBase userBase) {
        CommonUtils.newMethodCall("Update User");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userBase.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.updateAccountBase(userBase);
    }

    @Override
    public void updateAccountInfo(String userId, UserInfo userInfo) {
        CommonUtils.newMethodCall("Update User");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userInfo.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.updateAccountInfo(userInfo);
    }

    @Override
    public void createOrUpdateUserFriend(String userId, UserFriend userFriend) {
        CommonUtils.newMethodCall("Create/Update Friend");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userFriend.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.createOrUpdateUserFriend(userFriend);
    }

    @Override
    public List<UserFriend> getUserFollows(String userId, String lastUpdateTime) {
        CommonUtils.newMethodCall("Get User Follows");
        return accountService.getUserFollows(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public List<UserFriend> getUserFans(String userId, String lastUpdateTime) {
        CommonUtils.newMethodCall("Get User Fans");
        return accountService.getUserFans(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createUserAction(String userId, UserAction userAction) {
        CommonUtils.newMethodCall("Create User Action");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userAction.setActionFromId(CommonUtils.parseIntegerToNull(userId));
        accountService.createUserAction(userAction);
    }

    @Override
    public List<UserAction> getNewlyUserAction(String userId) {
        CommonUtils.newMethodCall("Get User Actions");
        return accountService.getNewlyUserAction(CommonUtils.parseIntegerToNull(userId));
    }

    @Override
    public List<SearchUserInfo> searchAccountInfoByName(String nickName) {
        CommonUtils.newMethodCall("Search User");
        return accountService.searchAccountInfoByName(nickName);
    }

    @Override
    public List<FriendSortInfo> getFriendSort(String userId, String lastUpdateTime) {
        CommonUtils.newMethodCall("Update friend sort Info");
        return accountService.getFriendSort(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public List<UserProp> getUserProps(String userId, String lastUpdateTime) {
        CommonUtils.newMethodCall("Get User Props");
        return accountService.getUserProps(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createOrUpdateUserProp(String userId, List<UserProp> userProps) {
        CommonUtils.newMethodCall("Create User Prop");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        for (UserProp userProp : userProps) {
            userProp.setUserId(CommonUtils.parseIntegerToNull(userId));
        }
        accountService.createOrUpdateUserProp(userProps);
    }
}
