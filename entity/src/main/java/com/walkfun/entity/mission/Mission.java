package com.walkfun.entity.mission;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mission {

    private Integer missionId;
    private Integer missionTypeId; //0 for steps times limit 1 for prop drop limit 2 for prop use for user
    private String missionName;
    private String missionRule;
    private String missionDescription;
    private Integer triggerSteps;
    private Integer triggerTimes;
    private Double  triggerDistances;
    private Integer triggerPropId;
    private Integer triggerPropNumbers;
    private Integer triggerUserNumbers;
    private double goldCoin;
    private double experience;
    private Date updateTime;

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

    public String getMissionRule() {
        return missionRule;
    }

    public void setMissionRule(String missionRule) {
        this.missionRule = missionRule;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public Integer getTriggerSteps() {
        return triggerSteps;
    }

    public void setTriggerSteps(Integer triggerSteps) {
        this.triggerSteps = triggerSteps;
    }

    public Integer getTriggerTimes() {
        return triggerTimes;
    }

    public void setTriggerTimes(Integer triggerTimes) {
        this.triggerTimes = triggerTimes;
    }

    public Double getTriggerDistances() {
        return triggerDistances;
    }

    public void setTriggerDistances(Double triggerDistances) {
        this.triggerDistances = triggerDistances;
    }

    public Integer getTriggerPropId() {
        return triggerPropId;
    }

    public void setTriggerPropId(Integer triggerPropId) {
        this.triggerPropId = triggerPropId;
    }

    public Integer getTriggerPropNumbers() {
        return triggerPropNumbers;
    }

    public void setTriggerPropNumbers(Integer triggerPropNumbers) {
        this.triggerPropNumbers = triggerPropNumbers;
    }

    public Integer getTriggerUserNumbers() {
        return triggerUserNumbers;
    }

    public void setTriggerUserNumbers(Integer triggerUserNumbers) {
        this.triggerUserNumbers = triggerUserNumbers;
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

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
