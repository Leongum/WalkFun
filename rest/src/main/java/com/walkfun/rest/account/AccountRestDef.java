package com.walkfun.rest.account;

import com.walkfun.entity.account.*;
import com.walkfun.rest.common.RestDef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/7/13
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
// The Java class will be hosted at the URI path "/account"
@Path("/account")
@Consumes({"*/xml", MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface AccountRestDef extends RestDef {

    //登录， 用户根据用户名和密码登录
    @GET
    @Path("/login/{" + PARAM_USER_NAME + "}/{" + PARAM_PASSWORD + "}")
    UserInfo getAccountInfo(
            @PathParam(PARAM_USER_NAME) String userName,
            @PathParam(PARAM_PASSWORD) String password);

    //根据用户ID和最后更新日期获取最新用户信息
    @GET
    @Path("/get/{" + PARAM_USER_ID + "}")
    UserInfo getAccountInfoByID(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    //创建新用户
    @POST
    @Path("/create")
    UserInfo createAccountInfo(UserBase userBase);

    //更新用户基本信息
    @PUT
    @Path("/update/base/{" + PARAM_USER_ID + "}")
    void updateAccountBase(@PathParam(PARAM_USER_ID) String userId,
                           UserBase userBase);

    //更新用户所有信息
    @PUT
    @Path("/update/detail/{" + PARAM_USER_ID + "}")
    void updateAccountInfo(@PathParam(PARAM_USER_ID) String userId,
                               UserInfo userInfo);

    //创建或者更新好友关系
    @POST
    @Path("/friends/create/{" + PARAM_USER_ID + "}")
    void createOrUpdateUserFriend(@PathParam(PARAM_USER_ID) String userId,
                                  UserFriend userFriend);

    //获取我的关注
    @GET
    @Path("/friends/get/{" + PARAM_USER_ID + "}")
    List<UserFriend> getUserFriends(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    //创建用户动作
    @POST
    @Path("/action/create/{" + PARAM_USER_ID + "}")
    void createUserAction(@PathParam(PARAM_USER_ID) String userId,
                          UserAction userAction);

    //获取最新的用户动作
    @GET
    @Path("/action/get/{" + PARAM_USER_ID + "}")
    List<UserAction> getNewlyUserAction(
            @PathParam(PARAM_USER_ID) String userId);

    //根据用户的昵称，搜索用户
    @GET
    @Path("/search/get/{" + PARAM_NICK_NAME + "}")
    List<SearchUserInfo> searchAccountInfoByName(
            @PathParam(PARAM_NICK_NAME) String nickName);

    //根据lastupdatetime获取最新好友更新之后的状态
    @GET
    @Path("/friendsort/get/{" + PARAM_USER_ID + "}")
    List<FriendSortInfo> getFriendSort(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    //获取用户道具
    @GET
    @Path("/props/get/{" + PARAM_USER_ID + "}")
    List<UserProp> getUserProps(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    //新增用户道具
    @POST
    @Path("/props/create/{" + PARAM_USER_ID + "}")
    void createOrUpdateUserProp(@PathParam(PARAM_USER_ID) String userId,
                          List<UserProp> userProps);
}
