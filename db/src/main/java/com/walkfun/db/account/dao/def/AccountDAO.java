package com.walkfun.db.account.dao.def;


import com.walkfun.entity.account.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AccountDAO {

    public UserInfo getAccountInfo(String userName, String password);

    public UserInfo getAccountInfoByName(String userName);

    public UserInfo getAccountInfoByID(Integer userId, Date lastUpdateTime);

    public void updateAccountInfo(UserInfo userInfo);

    public void updateAccountBase(UserBase userBase);

    public Integer createAccountInfo(UserBase userBase);

    public void createOrUpdateUserFriend(UserFriend userFriend);

    public List<UserFriend> getUserFollows(Integer userId, Date lastUpdateTime);

    public List<UserFriend> getUserFans(Integer userId, Date lastUpdateTime);

    public void createUserAction(UserAction userAction);

    public List<UserAction> getNewlyUserAction(Integer userId);

    public List<SearchUserInfo> searchAccountInfoByName(String nickName);

    public List<FriendSortInfo> getFriendSort(Integer userId, Date lastUpdateTime);
}
