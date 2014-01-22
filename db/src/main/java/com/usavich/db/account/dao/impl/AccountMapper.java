package com.usavich.db.account.dao.impl;

import com.usavich.entity.account.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AccountMapper {

    public UserInfo getAccountInfo(@Param("userEmail") String userEmail,
                                   @Param("password") String password);

    public int createBase(@Param("baseEntity") UserBase userBase);

    public void createDetail(@Param("detailEntity") UserInfo accountInfo);

    public UserInfo getAccountInfoByID(@Param("userId") Integer userId);

    public List<UserFriend> getUserFriends(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime);

    public void createUserFriend(@Param("entity") UserFriend userFriend);

    public void updateUserFriend(@Param("entity") UserFriend userFriend);

    public void updateAccountInfo(@Param("entity") UserInfo userInfo);

    public void updateAccountBase(@Param("entity") UserBase userBase);

    public UserLocation getUserLocation(@Param("userId") Integer userId);

    public List<UserLocation> getUserLocations();

    public void createUserLocation(@Param("entity") UserLocation userLocation);

    public void updateUserLocation(@Param("entity") UserLocation userLocation);

    public UserInfo getAccountInfoByMail(@Param("userEmail") String userEmail);

    public UserFriend getUserFriend(@Param("userId") Integer userId, @Param("friendId") Integer friendId);

    public void updateAccountPowerInfo(@Param("userId") Integer userId, @Param("remainingPower") double remainingPower);

    public List<UserInfo> getUserFollowerInformation(@Param("userId") Integer userId,@Param("from") Integer from, @Param("pageSize") Integer pageSize);
}
