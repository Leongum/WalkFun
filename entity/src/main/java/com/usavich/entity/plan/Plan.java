package com.usavich.entity.plan;

import com.usavich.common.lib.CustomDateDeserializer;
import com.usavich.common.lib.CustomDateSerializer;
import com.usavich.entity.mission.Mission;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-8
 * Time: 下午1:51
 * To change this template use File | Settings | File Templates.
 */
public class Plan {

    private Integer planId;
    private String planName;
    private String planDescription;
    private Integer planType; // 0 - easy 1 - complex
    private String missionIds;
    private Integer totalMissions;
    private Integer planShareUserId;
    private String planShareUserName;
    private Integer sharedPlan; // 0 system 1 shared
    private Integer cycleTime;
    private Integer duration;
    private Integer durationType; // 1 week 2 day
    private Integer planStatus; //0 enabled 1 deleted
    private Integer durationLast;
    private Integer planFlag;
    private Date lastUpdateTime;

    private List<Mission> missions;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public String getMissionIds() {
        return missionIds;
    }

    public void setMissionIds(String missionIds) {
        this.missionIds = missionIds;
    }

    public Integer getTotalMissions() {
        return totalMissions;
    }

    public void setTotalMissions(Integer totalMissions) {
        this.totalMissions = totalMissions;
    }

    public Integer getPlanShareUserId() {
        return planShareUserId;
    }

    public void setPlanShareUserId(Integer planShareUserId) {
        this.planShareUserId = planShareUserId;
    }

    public String getPlanShareUserName() {
        return planShareUserName;
    }

    public void setPlanShareUserName(String planShareUserName) {
        this.planShareUserName = planShareUserName;
    }

    public Integer getSharedPlan() {
        return sharedPlan;
    }

    public void setSharedPlan(Integer sharedPlan) {
        this.sharedPlan = sharedPlan;
    }

    public Integer getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(Integer cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDurationType() {
        return durationType;
    }

    public void setDurationType(Integer durationType) {
        this.durationType = durationType;
    }

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public Integer getPlanFlag() {
        return planFlag;
    }

    public void setPlanFlag(Integer planFlag) {
        this.planFlag = planFlag;
    }

    public Integer getDurationLast() {
        return durationLast;
    }

    public void setDurationLast(Integer durationLast) {
        this.durationLast = durationLast;
    }
}
