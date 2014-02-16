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
    private Integer picId;
    private Integer userTitleId;
    private String userTitle;
    private String userFatDesc;
    private Double level;
    private Double goldCoin;
    private Double experience;
    private Double health;
    private Double fatness;
    private Double totalDistance;
    private Double totalCarlorie;
    private Double totalSteps;
    private Double totalWalkingTimes;
    private Double totalActiveTimes;
    private Double avgSpeed;
    private Integer currentCombo;
    private Integer maxCombo;
    private String propHaving;
    private Date updateTime;

    public UserInfo() {

    }

    public UserInfo(UserBase userBase) {
        this.setUserId(userBase.getUserId());
        this.setUuid(userBase.getUuid());
        this.setDeviceId(userBase.getDeviceId());
        this.setUserName(userBase.getUserName());
        this.setNickName(userBase.getNickName());
        this.setPassword(userBase.getPassword());
        this.setSex(userBase.getSex());
        this.setAge(userBase.getAge());
        this.setHeight(userBase.getHeight());
        this.setWeight(userBase.getWeight());
        this.setPlatformInfo(userBase.getPlatformInfo());
        this.userTitleId = 0;
        this.userTitle = "新手上路";
        this.level = 0d;
        this.goldCoin = 0d;
        this.experience = 0d;
        this.health = 0d;
        this.fatness = 0d;
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

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
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

    public Double getGoldCoin() {
        return goldCoin;
    }

    public void setGoldCoin(Double goldCoin) {
        this.goldCoin = goldCoin;
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

    public String getUserFatDesc() {
        return userFatDesc;
    }

    public void setUserFatDesc(String userFatDesc) {
        this.userFatDesc = userFatDesc;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Double getFatness() {
        return fatness;
    }

    public void setFatness(Double fatness) {
        this.fatness = fatness;
    }

    public String getPropHaving() {
        return propHaving;
    }

    public void setPropHaving(String propHaving) {
        this.propHaving = propHaving;
    }
}
