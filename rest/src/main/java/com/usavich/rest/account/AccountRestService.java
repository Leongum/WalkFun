package com.usavich.rest.account;

import com.usavich.common.lib.CommonUtils;
import com.usavich.entity.account.*;
import com.usavich.service.account.def.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
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
        CommonUtils.newMethodCall("AccountRestService.getAccountInfo");
        UserInfo userInfo = accountService.getAccountInfo(userEmail, password);
        userInfo.setUuid(UUID.randomUUID().toString());
        UserBase userBase = new UserBase();
        userBase = userBase.initUserBase(userInfo);
        accountService.updateAccountBase(userBase);
        return  userInfo;
    }

    @Override
    public UserInfo getAccountInfoByID(String userId, String checkUuid) {
        CommonUtils.newMethodCall("AccountRestService.getAccountInfoByID");
        if (checkUuid != null && checkUuid.equalsIgnoreCase("true")) {
            accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        }
        UserInfo userInfo =  accountService.getAccountInfoByID(CommonUtils.parseIntegerToNull(userId));
        return  userInfo;
    }

    @Override
    public UserInfo createAccountInfo(UserBase userBase) {
        CommonUtils.newMethodCall("AccountRestService.createAccountInfo");
        userBase.setUuid(UUID.randomUUID().toString());
        UserInfo userInfo = accountService.createAccountInfo(userBase);
        return  userInfo;
    }

    @Override
    public void updateAccountBase(String userId, UserBase userBase) {
        CommonUtils.newMethodCall("AccountRestService.updateAccountBase");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userBase.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.updateAccountBase(userBase);
    }

    @Override
    public UserInfo updateAccountAdditional(String userId, UserInfo userInfo) {
        CommonUtils.newMethodCall("AccountRestService.updateAccountAdditional");
        Integer userIdInt = CommonUtils.parseIntegerToNull(userId);
        accountService.checkUserLoginStatus(userIdInt);
        UserInfo userInfoBase = accountService.getAccountInfoByID(userIdInt);
        userInfoBase.setWeight(userInfo.getWeight());
        userInfoBase.setHeight(userInfo.getHeight());
        userInfoBase.setAge(userInfo.getAge());
        if (userInfo.getSex() != null && !userInfo.getSex().equalsIgnoreCase(userInfoBase.getSex())) {
            userInfoBase.setSex(userInfo.getSex());
            UserBase userBase = new UserBase();
            userBase = userBase.initUserBase(userInfoBase);
            accountService.updateAccountBase(userBase);
        }
        accountService.updateAccountInfo(userInfoBase);
        return  userInfoBase;
    }

    @Override
    public List<UserFriend> getUserFriends(String userId,String lastUpdateTime) {
        CommonUtils.newMethodCall("AccountRestService.getUserFriends");
        return accountService.getUserFriends(CommonUtils.parseIntegerToNull(userId),CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createUserFriendInvite(String userId, UserFriend userFriend) {
        CommonUtils.newMethodCall("AccountRestService.createUserFriendInvite");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userFriend.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.createUserFriendInvite(userFriend);
    }

    @Override
    public void updateUserFriendStatus(String userId, UserFriend userFriend) {
        CommonUtils.newMethodCall("AccountRestService.updateUserFriendStatus");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userFriend.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.updateUserFriendStatus(userFriend);
    }

    @Override
    public UserLocation getUserLocation(String userId) {
        CommonUtils.newMethodCall("AccountRestService.getUserLocation");
        return accountService.getUserLocation(CommonUtils.parseIntegerToNull(userId));
    }

    @Override
    public void updateUserLocation(String userId, UserLocation userLocation) {
        CommonUtils.newMethodCall("AccountRestService.updateUserLocation");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        userLocation.setUserId(CommonUtils.parseIntegerToNull(userId));
        accountService.updateUserLocation(userLocation);
    }

    @Override
    public List<UserInfo> getUserFollowerInformation(String userId, String pageNo) {
        CommonUtils.newMethodCall("AccountRestService.getUserFollowerInformation");
        return accountService.getUserFollowerInformation(CommonUtils.parseIntegerToNull(userId),CommonUtils.parseIntegerToNull(pageNo));
    }
}
