package com.walkfun.db.account.dao.impl;

import com.walkfun.entity.account.*;
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

    public UserInfo getAccountInfoByID(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime);

    public UserInfo getAccountInfo(@Param("userName") String userName, @Param("password") String password);

    public UserInfo getAccountInfoByName(@Param("userName") String userName);

    public int createAccountBase(@Param("baseEntity") UserBase userBase);

    public void updateAccountBase(@Param("baseEntity") UserBase userBase);

    public void createAccountDetail(@Param("detailEntity") UserInfo accountInfo);

    public void updateAccountDetail(@Param("detailEntity") UserInfo userInfo);

    public UserFriend getFriendById(@Param("userId") Integer userId, @Param("friendId") Integer friendId);

    public void createOrUpdateUserFriend(@Param("entity") UserFriend userFriend);

    public List<UserFriend> getUserFriends(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime);

    public void createUserAction(@Param("entity") UserAction userAction);

    public List<UserAction> getNewlyUserAction(@Param("userId") Integer userId);

    public void updateUserActionSyncTime(@Param("userId") Integer userId);

    public List<SearchUserInfo> searchAccountInfoByName(@Param("nickName") String nickName);

    public List<FriendSortInfo> getFriendSort(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime);

    public List<UserProp> getUserProps(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime);

    public void createOrUpdateUserProp(@Param("entity") UserProp userProp);
}
