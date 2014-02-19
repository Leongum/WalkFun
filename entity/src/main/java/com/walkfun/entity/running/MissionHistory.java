package com.walkfun.entity.running;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-1-22
 * Time: 下午10:34
 * To change this template use File | Settings | File Templates.
 */
public class MissionHistory {

    private String missionUuid;
    private Integer userId;
    private String userName;
    private Integer missionId;
    private Integer missionTypeId;
    private String missionName;
    private Date startTime;
    private Date endTime;
    private Integer missionStatus; //0 success 1 failed
    private String missionStatusComment;
    private Date updateTime;

    public String getMissionUuid() {
        return missionUuid;
    }

    public void setMissionUuid(String missionUuid) {
        this.missionUuid = missionUuid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public Integer getMissionTypeId() {
        return missionTypeId;
    }

    public void setMissionTypeId(Integer missionTypeId) {
        this.missionTypeId = missionTypeId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public Integer getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(Integer missionStatus) {
        this.missionStatus = missionStatus;
    }

    public String getMissionStatusComment() {
        return missionStatusComment;
    }

    public void setMissionStatusComment(String missionStatusComment) {
        this.missionStatusComment = missionStatusComment;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getStartTime() {
        return startTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEndTime() {
        return endTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
