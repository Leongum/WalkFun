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
    private Double level;
    private Double goldCoin;
    private Double experience;
    private Double fatness;
    private Double power;
    private Double powerPlus;
    private Double fight;
    private Double fightPlus;
    private Double totalDistance;
    private Double totalCarlorie;
    private Integer totalSteps;
    private Integer totalWalkingTimes;
    private Integer totalActiveTimes;
    private Integer totalFights;
    private Integer fightsWin;
    private Integer totalFriendFights;
    private Integer friendFightWin;
    private Integer missionCombo;
    private String propHaving;
    private Date updateTime;

    public UserInfo() {

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
        if (goldCoin < 0) {
            goldCoin = 0d;
        }
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

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getFatness() {
        return fatness;
    }

    public void setFatness(Double fatness) {
        if (fatness < 0) {
            this.fatness = 0.0;
        }
        if (fatness > 100) {
            this.fatness = 100.0;
        }
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

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getPowerPlus() {
        return powerPlus;
    }

    public void setPowerPlus(Double powerPlus) {
        this.powerPlus = powerPlus;
    }

    public Double getFight() {
        return fight;
    }

    public void setFight(Double fight) {
        this.fight = fight;
    }

    public Double getFightPlus() {
        return fightPlus;
    }

    public void setFightPlus(Double fightPlus) {
        this.fightPlus = fightPlus;
    }

    public Integer getTotalFights() {
        return totalFights;
    }

    public void setTotalFights(Integer totalFights) {
        this.totalFights = totalFights;
    }

    public Integer getFightsWin() {
        return fightsWin;
    }

    public void setFightsWin(Integer fightsWin) {
        this.fightsWin = fightsWin;
    }

    public Integer getTotalFriendFights() {
        return totalFriendFights;
    }

    public void setTotalFriendFights(Integer totalFriendFights) {
        this.totalFriendFights = totalFriendFights;
    }

    public Integer getFriendFightWin() {
        return friendFightWin;
    }

    public void setFriendFightWin(Integer friendFightWin) {
        this.friendFightWin = friendFightWin;
    }
}
