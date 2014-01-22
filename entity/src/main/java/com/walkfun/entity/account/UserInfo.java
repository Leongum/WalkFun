package com.walkfun.entity.account;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo extends UserBase {

    private Integer userId;
    private Integer userTitleId;
    private String userTitle;
    private Double level;
    private Double scores;
    private Double experience;
    private Double totalDistance;
    private Double totalCarlorie;
    private Double totalSteps;
    private Double totalWalkingTimes;
    private Double totalActiveTimes;
    private Double avgSpeed;
    private Date lastActiveTime;
    private Double lastWalkingTime;
    private Double lastWalkingSteps;
    private Double lastWalkingDistance;
    private String lastWalkingPoint;
    private String lastWalkingAddress;
    private Integer currentCombo;
    private Integer maxCombo;
    private Date updateTime;

    public UserInfo() {

    }

    public UserInfo(UserBase userBase) {
        this.setUserId(userBase.getUserId());
        this.setDeviceId(userBase.getDeviceId());
        this.setUserName(userBase.getUserName());
        this.setNickName(userBase.getNickName());
        this.setPassword(userBase.getPassword());
        this.setSex(userBase.getSex());
        this.setAge(userBase.getAge());
        this.setHeight(userBase.getHeight());
        this.setWeight(userBase.getWeight());
        this.totalDistance = 0d;
        this.totalCarlorie = 0d;
        this.totalSteps = 0d;
        this.totalWalkingTimes = 0d;
        this.totalActiveTimes = 0d;
        this.avgSpeed = 0d;
        this.currentCombo = 0;
        this.maxCombo = 0;
        this.updateTime = new Date();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserTitleId() {
        return userTitleId;
    }

    public void setUserTitleId(Integer userTitleId) {
        this.userTitleId = userTitleId;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public Double getScores() {
        return scores;
    }

    public void setScores(Double scores) {
        this.scores = scores;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Double getTotalCarlorie() {
        return totalCarlorie;
    }

    public void setTotalCarlorie(Double totalCarlorie) {
        this.totalCarlorie = totalCarlorie;
    }

    public Double getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(Double totalSteps) {
        this.totalSteps = totalSteps;
    }

    public Double getTotalWalkingTimes() {
        return totalWalkingTimes;
    }

    public void setTotalWalkingTimes(Double totalWalkingTimes) {
        this.totalWalkingTimes = totalWalkingTimes;
    }

    public Double getTotalActiveTimes() {
        return totalActiveTimes;
    }

    public void setTotalActiveTimes(Double totalActiveTimes) {
        this.totalActiveTimes = totalActiveTimes;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public Double getLastWalkingTime() {
        return lastWalkingTime;
    }

    public void setLastWalkingTime(Double lastWalkingTime) {
        this.lastWalkingTime = lastWalkingTime;
    }

    public Double getLastWalkingSteps() {
        return lastWalkingSteps;
    }

    public void setLastWalkingSteps(Double lastWalkingSteps) {
        this.lastWalkingSteps = lastWalkingSteps;
    }

    public Double getLastWalkingDistance() {
        return lastWalkingDistance;
    }

    public void setLastWalkingDistance(Double lastWalkingDistance) {
        this.lastWalkingDistance = lastWalkingDistance;
    }

    public String getLastWalkingPoint() {
        return lastWalkingPoint;
    }

    public void setLastWalkingPoint(String lastWalkingPoint) {
        this.lastWalkingPoint = lastWalkingPoint;
    }

    public String getLastWalkingAddress() {
        return lastWalkingAddress;
    }

    public void setLastWalkingAddress(String lastWalkingAddress) {
        this.lastWalkingAddress = lastWalkingAddress;
    }

    public Integer getCurrentCombo() {
        return currentCombo;
    }

    public void setCurrentCombo(Integer currentCombo) {
        this.currentCombo = currentCombo;
    }

    public Integer getMaxCombo() {
        return maxCombo;
    }

    public void setMaxCombo(Integer maxCombo) {
        this.maxCombo = maxCombo;
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
