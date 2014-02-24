package com.walkfun.entity.account;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigInteger;
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
    private String userTitle;
    private String userTitlePic;
    private String userFatDesc;
    private Double level;
    private Double goldCoin;
    private Double goldCoinSpeed;
    private Double experience;
    private Double experienceSpeed;
    private Double health;
    private Double fatness;
    private Double totalDistance;
    private Double totalCarlorie;
    private Integer totalSteps;
    private Integer totalWalkingTimes;
    private Integer totalActiveTimes;
    private Integer currentCombo;
    private Integer maxCombo;
    private Integer missionCombo;
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
        this.userTitle = "新手上路";
        this.userTitlePic ="http://cyberace.qiniudn.com/walkfun1.png";
        this.level = 0d;
        this.goldCoin = 0d;
        this.goldCoinSpeed = 0d;
        this.experience = 0d;
        this.experienceSpeed = 0d;
        this.health = 0d;
        this.fatness = 0d;
        this.totalDistance = 0d;
        this.totalCarlorie = 0d;
        this.totalSteps = 0;
        this.totalWalkingTimes = 0;
        this.totalActiveTimes = 0;
        this.currentCombo = 0;
        this.maxCombo = 0;
        this.missionCombo = 0;
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

    public String getUserTitlePic() {
        return userTitlePic;
    }

    public void setUserTitlePic(String userTitlePic) {
        this.userTitlePic = userTitlePic;
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

    public Integer getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(Integer totalSteps) {
        this.totalSteps = totalSteps;
    }

    public Integer getTotalWalkingTimes() {
        return totalWalkingTimes;
    }

    public void setTotalWalkingTimes(Integer totalWalkingTimes) {
        this.totalWalkingTimes = totalWalkingTimes;
    }

    public Integer getTotalActiveTimes() {
        return totalActiveTimes;
    }

    public void setTotalActiveTimes(Integer totalActiveTimes) {
        this.totalActiveTimes = totalActiveTimes;
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

    public Integer getMissionCombo() {
        return missionCombo;
    }

    public void setMissionCombo(Integer missionCombo) {
        this.missionCombo = missionCombo;
    }

    public Double getGoldCoinSpeed() {
        return goldCoinSpeed;
    }

    public void setGoldCoinSpeed(Double goldCoinSpeed) {
        this.goldCoinSpeed = goldCoinSpeed;
    }

    public Double getExperienceSpeed() {
        return experienceSpeed;
    }

    public void setExperienceSpeed(Double experienceSpeed) {
        this.experienceSpeed = experienceSpeed;
    }
}
