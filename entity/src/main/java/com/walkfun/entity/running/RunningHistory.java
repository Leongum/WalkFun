package com.walkfun.entity.running;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/24/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class RunningHistory {
    private Integer userId;
    private String runUuid;
    private Integer missionId;
    private Integer missionTypeId;
    private String missionRoute;
    private Date missionStartTime;
    private Date missionEndTime;
    private Date missionDate;
    private double spendCarlorie;
    private Integer duration;
    private double avgSpeed;
    private Integer steps;
    private double distance;
    private Integer missionGrade;
    private double goldCoin;
    private double extraGoldCoin;
    private double experience;
    private double extraExperience;
    private double fatness;
    private double health;
    private String comment;
    private Integer valid;
    private String missionUuid;
    private Integer sequence;
    private String propGet;
    private String actionIds;
    private Integer friendId;
    private String friendName;
    private Date commitTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRunUuid() {
        return runUuid;
    }

    public void setRunUuid(String runUuid) {
        this.runUuid = runUuid;
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

    public String getMissionRoute() {
        return missionRoute;
    }

    public void setMissionRoute(String missionRoute) {
        this.missionRoute = missionRoute;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getMissionStartTime() {
        return missionStartTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setMissionStartTime(Date missionStartTime) {
        this.missionStartTime = missionStartTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getMissionEndTime() {
        return missionEndTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setMissionEndTime(Date missionEndTime) {
        this.missionEndTime = missionEndTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getMissionDate() {
        return missionDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setMissionDate(Date missionDate) {
        this.missionDate = missionDate;
    }

    public double getSpendCarlorie() {
        return spendCarlorie;
    }

    public void setSpendCarlorie(double spendCarlorie) {
        this.spendCarlorie = spendCarlorie;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getGoldCoin() {
        return goldCoin;
    }

    public void setGoldCoin(double goldCoin) {
        this.goldCoin = goldCoin;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getExtraExperience() {
        return extraExperience;
    }

    public void setExtraExperience(double extraExperience) {
        this.extraExperience = extraExperience;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCommitTime() {
        return commitTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Integer getMissionGrade() {
        return missionGrade;
    }

    public void setMissionGrade(Integer missionGrade) {
        this.missionGrade = missionGrade;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getMissionUuid() {
        return missionUuid;
    }

    public void setMissionUuid(String missionUuid) {
        this.missionUuid = missionUuid;
    }

    public String getPropGet() {
        return propGet;
    }

    public void setPropGet(String propGet) {
        this.propGet = propGet;
    }

    public double getExtraGoldCoin() {
        return extraGoldCoin;
    }

    public void setExtraGoldCoin(double extraGoldCoin) {
        this.extraGoldCoin = extraGoldCoin;
    }

    public String getActionIds() {
        return actionIds;
    }

    public void setActionIds(String actionIds) {
        this.actionIds = actionIds;
    }

    public double getFatness() {
        return fatness;
    }

    public void setFatness(double fatness) {
        this.fatness = fatness;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

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
}
