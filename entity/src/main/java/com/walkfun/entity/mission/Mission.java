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
    private Integer missionTypeId;
    private String missionName;
    private String missionDescription;
    private double scores;
    private double experience;
    private Integer missionFlag;
    private double levelLimited;
    private BigInteger missionTimeLimited;
    private double missionDistanceLimited;
    private Date missionFromTimeLimited;
    private Date missionToTimeLimited;
    private double cycleTime;
    private double suggestionMaxSpeed;
    private double suggestionMinSpeed;
    private Integer sequence;
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

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public double getScores() {
        return scores;
    }

    public void setScores(double scores) {
        this.scores = scores;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public Integer getMissionFlag() {
        return missionFlag;
    }

    public void setMissionFlag(Integer missionFlag) {
        this.missionFlag = missionFlag;
    }

    public double getLevelLimited() {
        return levelLimited;
    }

    public void setLevelLimited(double levelLimited) {
        this.levelLimited = levelLimited;
    }

    public BigInteger getMissionTimeLimited() {
        return missionTimeLimited;
    }

    public void setMissionTimeLimited(BigInteger missionTimeLimited) {
        this.missionTimeLimited = missionTimeLimited;
    }

    public double getMissionDistanceLimited() {
        return missionDistanceLimited;
    }

    public void setMissionDistanceLimited(double missionDistanceLimited) {
        this.missionDistanceLimited = missionDistanceLimited;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getMissionFromTimeLimited() {
        return missionFromTimeLimited;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setMissionFromTimeLimited(Date missionFromTimeLimited) {
        this.missionFromTimeLimited = missionFromTimeLimited;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getMissionToTimeLimited() {
        return missionToTimeLimited;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setMissionToTimeLimited(Date missionToTimeLimited) {
        this.missionToTimeLimited = missionToTimeLimited;
    }

    public double getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(double cycleTime) {
        this.cycleTime = cycleTime;
    }

    public double getSuggestionMaxSpeed() {
        return suggestionMaxSpeed;
    }

    public void setSuggestionMaxSpeed(double suggestionMaxSpeed) {
        this.suggestionMaxSpeed = suggestionMaxSpeed;
    }

    public double getSuggestionMinSpeed() {
        return suggestionMinSpeed;
    }

    public void setSuggestionMinSpeed(double suggestionMinSpeed) {
        this.suggestionMinSpeed = suggestionMinSpeed;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
