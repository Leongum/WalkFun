package com.walkfun.service.account.def;

import com.walkfun.entity.account.*;

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

    public void checkUserLoginStatus(Integer userId);

    public UserInfo getAccountInfo(String userName, String password);

    public UserInfo getAccountInfoByID(Integer userId, Date lastUpdateTime);

    public void updateAccountInfo(UserInfo userInfo);

    public void updateAccountBase(UserBase userBase);

    public UserInfo createAccountInfo(UserBase userBase);

    public void createOrUpdateUserFriend(UserFriend userFriend);

    public List<UserFriend> getUserFriends(Integer userId, Date lastUpdateTime);

    public void createUserAction(UserAction userAction);

    public List<UserAction> getNewlyUserAction(Integer userId);

    public List<SearchUserInfo> searchAccountInfoByName(String nickName);

    public List<FriendSortInfo> getFriendSort(Integer userId, Date lastUpdateTime);

    public List<UserProp> getUserProps(Integer userId, Date lastUpdateTime);

    public void createOrUpdateUserProp(List<UserProp> userProps);
}
