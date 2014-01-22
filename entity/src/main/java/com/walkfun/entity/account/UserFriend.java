package com.walkfun.entity.account;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 5/28/13
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserFriend{

    private Integer userId;
    private Integer friendId;
    private Integer friendStatus; //'0 - 关注 1 - 删除',
    private Integer friendEach;   //'0 - 仅关注 1 - 相互关注',
    private Date addTime;
    private Date updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
    }

    public Integer getFriendEach() {
        return friendEach;
    }

    public void setFriendEach(Integer friendEach) {
        this.friendEach = friendEach;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getAddTime() {
        return addTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
