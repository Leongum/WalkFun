package com.usavich.service.account.impl;

import com.usavich.common.exception.*;
import com.usavich.common.lib.Universe;
import com.usavich.db.account.dao.def.AccountDAO;
import com.usavich.service.account.def.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import com.usavich.entity.account.*;
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
        if (userId > 0) {
            UserInfo userInfo = accountDAO.getAccountInfoByID(userId);
            if (userInfo == null || userInfo.getUserId() != Universe.current().getUserId()) {
                throw new ServerRequestException(ErrorMessageMapper.LOGIN_CHECK_FAIL.toString());
            }
            if (!userInfo.getUuid().equalsIgnoreCase(Universe.current().getUuid())) {
                throw new ServerRequestException(ErrorMessageMapper.LOGIN_CHECK_FAIL.toString());
            }
        } else {
            throw new ServerRequestException(ErrorMessageMapper.LOGIN_CHECK_FAIL.toString());
        }
    }

    private UserInfo checkUserExisting(Integer userId) {
        UserInfo userInfo = accountDAO.getAccountInfoByID(userId);
        if (userInfo == null || userInfo.getUserId() == null) {
            throw new ServerRequestException(ErrorMessageMapper.USER_NOT_FOUND.toString());
        }
        return userInfo;
    }

    @Override
    public UserInfo getAccountInfo(String userEmail, String password) {
        UserInfo userInfo = accountDAO.getAccountInfo(userEmail, password);
        if (userInfo == null || userInfo.getUserId() == null) {
            throw new ServerRequestException(ErrorMessageMapper.USER_NOT_FOUND.toString());
        }
        return userInfo;
    }

    @Override
    @Transactional
    public UserInfo createAccountInfo(UserBase userBase) {
        UserInfo userInfo = accountDAO.getAccountInfoByMail(userBase.getUserEmail());
        if (userInfo != null && userInfo.getUserId() != null) {
            throw new ServerRequestException(ErrorMessageMapper.USER_ALREADY_EXISTS.toString());
        }
        return accountDAO.createAccountInfo(userBase);
    }

    @Override
    public UserInfo getAccountInfoByID(Integer userId) {
        return checkUserExisting(userId);
    }

    @Override
    public List<UserFriend> getUserFriends(Integer userId, Date lastUpdateTime) {
        checkUserExisting(userId);
        return accountDAO.getUserFriends(userId, lastUpdateTime);
    }

    @Override
    @Transactional
    public void updateAccountInfo(UserInfo userInfo) {
        checkUserExisting(userInfo.getUserId());
        accountDAO.updateAccountInfo(userInfo);
    }

    @Override
    @Transactional
    public void updateAccountBase(UserBase userBase) {
        checkUserExisting(userBase.getUserId());
        accountDAO.updateAccountBase(userBase);
    }

    @Override
    @Transactional
    public void createUserFriendInvite(UserFriend userFriend) {
        //check user existing
        checkUserExisting(userFriend.getUserId());
        checkUserExisting(userFriend.getFriendId());
        //check friendship existing
        UserFriend userFriendCheck = accountDAO.getUserFriend(userFriend.getUserId(), userFriend.getFriendId());
        if (userFriendCheck != null && userFriendCheck.getFriendStatus() != null) {
            throw new ServerRequestException(ErrorMessageMapper.FRIENDSHIP_EXISTS.toString());
        }
        accountDAO.createUserFriendInvite(userFriend);
    }

    @Override
    @Transactional
    public void updateUserFriendStatus(UserFriend userFriend) {
        UserFriend userFriendCheck = accountDAO.getUserFriend(userFriend.getUserId(), userFriend.getFriendId());
        if (userFriendCheck == null || userFriendCheck.getFriendStatus() == null) {
            throw new ServerRequestException(ErrorMessageMapper.FRIENDSHIP_NOT_EXISTS.toString());
        }
        //check friendship status is ok to set
        if (userFriendCheck.getFriendStatus() > userFriend.getFriendStatus()) {
            throw new ServerRequestException(ErrorMessageMapper.FRIEND_STATUS_ERROR.toString());
        }
        accountDAO.updateUserFriendStatus(userFriend);
    }

    @Override
    public UserLocation getUserLocation(Integer userId) {
        checkUserExisting(userId);
        return accountDAO.getUserLocation(userId);
    }

    @Override
    @Transactional
    public void updateUserLocation(UserLocation userLocation) {
        checkUserExisting(userLocation.getUserId());
        accountDAO.updateUserLocation(userLocation);
    }

    @Override
    public List<UserLocation> getUserLocations() {
        return accountDAO.getUserLocations();
    }

    @Override
    public List<UserInfo> getUserFollowerInformation(Integer userId, Integer pageNo) {
        Integer from = pageNo == null ? 0 : pageNo * 10;
        Integer pageSize = 10;
        return accountDAO.getUserFollowerInformation(userId, from, pageSize);
    }
}
