package com.usavich.service.account.def;

import com.usavich.entity.account.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/6/13
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AccountService {

    UserInfo getAccountInfo(String userEmail, String password);

    UserInfo createAccountInfo(UserBase userBase);

    void checkUserLoginStatus(Integer userId);

    UserInfo getAccountInfoByID(Integer userId);

    List<UserFriend> getUserFriends(Integer userId, Date lastUpdateTime);

    void updateAccountInfo(UserInfo userInfo);

    void updateAccountBase(UserBase userBase);

    void createUserFriendInvite(UserFriend userFriend);

    void updateUserFriendStatus(UserFriend userFriend);

    UserLocation getUserLocation(Integer userId);

    void updateUserLocation(UserLocation userLocation);

    List<UserLocation> getUserLocations();

    List<UserInfo> getUserFollowerInformation(Integer userId, Integer pageNo);
}
