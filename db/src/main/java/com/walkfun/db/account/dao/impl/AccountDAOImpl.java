package com.walkfun.db.account.dao.impl;

import com.walkfun.db.account.dao.def.AccountDAO;
import com.walkfun.entity.enums.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.walkfun.entity.account.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public UserInfo getAccountInfo(String userName, String password) {
        return accountMapper.getAccountInfo(userName, password);
    }

    @Override
    public UserInfo getAccountInfoByName(String userName) {
        return accountMapper.getAccountInfoByName(userName);
    }

    @Override
    public UserInfo getAccountInfoByID(Integer userId, Date lastUpdateTime) {
        return accountMapper.getAccountInfoByID(userId, lastUpdateTime);
    }

    @Override
    public Integer createAccountInfo(UserBase userBase) {
        accountMapper.createAccountBase(userBase);
        return userBase.getUserId();
    }

    @Override
    public void updateAccountInfo(UserInfo userInfo) {
        accountMapper.updateAccountDetail(userInfo);
    }

    @Override
    public void updateAccountBase(UserBase userBase) {
        accountMapper.updateAccountBase(userBase);
    }

    @Override
    public void createOrUpdateUserFriend(UserFriend userFriend) {
        UserFriend friendFollow = accountMapper.getFriendById(userFriend.getFriendId(), userFriend.getUserId());
        if (friendFollow == null) {
            userFriend.setFriendEach(FriendStatusEnum.ONLYFOLLOWED.ordinal());
        } else {
            if (userFriend.getFriendStatus() == FollowStatusEnum.FOLLOWED.ordinal()) {
                if (friendFollow.getFriendStatus() == FollowStatusEnum.FOLLOWED.ordinal()) {
                    friendFollow.setFriendEach(FriendStatusEnum.FOLLOWEACHOTHER.ordinal());
                    userFriend.setFriendEach(FriendStatusEnum.FOLLOWEACHOTHER.ordinal());
                } else if (friendFollow.getFriendStatus() == FollowStatusEnum.DELETED.ordinal()) {
                    friendFollow.setFriendEach(null);
                    userFriend.setFriendEach(FriendStatusEnum.ONLYFOLLOWED.ordinal());
                }
            } else if (userFriend.getFriendStatus() == FollowStatusEnum.DELETED.ordinal()) {
                if (friendFollow.getFriendStatus() == FollowStatusEnum.FOLLOWED.ordinal()) {
                    friendFollow.setFriendEach(FriendStatusEnum.ONLYFOLLOWED.ordinal());
                    userFriend.setFriendEach(null);
                } else if (friendFollow.getFriendStatus() == FollowStatusEnum.DELETED.ordinal()) {
                    friendFollow.setFriendEach(null);
                    userFriend.setFriendEach(null);
                }
            }
        }
        accountMapper.createOrUpdateUserFriend(userFriend);
        if(friendFollow != null){
            accountMapper.createOrUpdateUserFriend(friendFollow);
        }
        //todo:: send message to client.
    }

    @Override
    public List<UserFriend> getUserFollows(Integer userId, Date lastUpdateTime) {
        return accountMapper.getUserFollows(userId, lastUpdateTime);
    }

    @Override
    public List<UserFriend> getUserFans(Integer userId, Date lastUpdateTime) {
        return accountMapper.getUserFans(userId, lastUpdateTime);
    }

    @Override
    public void createUserAction(UserAction userAction) {
        accountMapper.createUserAction(userAction);
        //todo:: send message to client.
    }

    @Override
    public List<UserAction> getNewlyUserAction(Integer userId) {
        List<UserAction> userActionList = accountMapper.getNewlyUserAction(userId);
        accountMapper.updateUserActionSyncTime(userId);
        return  userActionList;
    }

    @Override
    public List<SearchUserInfo> searchAccountInfoByName(String nickName) {
        return accountMapper.searchAccountInfoByName(nickName);
    }

    @Override
    public List<FriendSortInfo> getFriendSort(Integer userId, Date lastUpdateTime) {
        return accountMapper.getFriendSort(userId, lastUpdateTime);
    }
}
