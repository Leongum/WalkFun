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
    private String missionName;
    private Date startTime;
    private Date endTime;
    private Date lastRunTime;
    private Integer histroyStatus;
    private Integer currentCombo;
    private Integer totalActiveTimes;
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

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
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
    public Date getLastRunTime() {
        return lastRunTime;
    }

    public void setLastRunTime(Date lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public Integer getHistroyStatus() {
        return histroyStatus;
    }

    public void setHistroyStatus(Integer histroyStatus) {
        this.histroyStatus = histroyStatus;
    }

    public Integer getCurrentCombo() {
        return currentCombo;
    }

    public void setCurrentCombo(Integer currentCombo) {
        this.currentCombo = currentCombo;
    }

    public Integer getTotalActiveTimes() {
        return totalActiveTimes;
    }

    public void setTotalActiveTimes(Integer totalActiveTimes) {
        this.totalActiveTimes = totalActiveTimes;
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
