package com.walkfun.entity.account;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-1-23
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class FriendSortInfo {

    private Integer friendId;
    private String friendName;
    private String sex;
    private Double level;
    private String userTitle;
    private Double totalDistance;
    private Integer friendStatus;
    private Date lastActiveTime;

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
    }
}
