package com.usavich.entity.mission;

import com.usavich.common.lib.CustomDateDeserializer;
import com.usavich.common.lib.CustomDateSerializer;
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
    private String missionContent;
    private double scores;
    private double experience;
    private Integer missionFlag;
    private double levelLimited;
    private BigInteger missionTime;
    private double missionDistance;
    private double cycleTime;
    private String missionFrom;
    private String missionTo;
    private Integer missionPlacePackageId;
    private List<MissionPlacePackage> missionPlacePackages;
    private Integer challengeId;
    private List<MissionChallenge> missionChallenges;
    private BigInteger missionSteps;
    private double missionSpeed;
    private Date lastUpdateTime;
    private String subMissionList;
    private Integer missionPackageId;
    private Integer sequence;
    private Integer planId;
    private double suggestionMaxSpeed;
    private double suggestionMinSpeed;

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

    public String getMissionContent() {
        return missionContent;
    }

    public void setMissionContent(String missionContent) {
        this.missionContent = missionContent;
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

    public BigInteger getMissionTime() {
        return missionTime;
    }

    public void setMissionTime(BigInteger missionTime) {
        this.missionTime = missionTime;
    }

    public double getMissionDistance() {
        return missionDistance;
    }

    public void setMissionDistance(double missionDistance) {
        this.missionDistance = missionDistance;
    }

    public double getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(double cycleTime) {
        this.cycleTime = cycleTime;
    }

    public String getMissionFrom() {
        return missionFrom;
    }

    public void setMissionFrom(String missionFrom) {
        this.missionFrom = missionFrom;
    }

    public String getMissionTo() {
        return missionTo;
    }

    public void setMissionTo(String missionTo) {
        this.missionTo = missionTo;
    }

    public Integer getMissionPlacePackageId() {
        return missionPlacePackageId;
    }

    public void setMissionPlacePackageId(Integer missionPlacePackageId) {
        this.missionPlacePackageId = missionPlacePackageId;
    }

    public BigInteger getMissionSteps() {
        return missionSteps;
    }

    public void setMissionSteps(BigInteger missionSteps) {
        this.missionSteps = missionSteps;
    }

    public double getMissionSpeed() {
        return missionSpeed;
    }

    public void setMissionSpeed(double missionSpeed) {
        this.missionSpeed = missionSpeed;
    }

    public List<MissionPlacePackage> getMissionPlacePackages() {
        return missionPlacePackages;
    }

    public void setMissionPlacePackages(List<MissionPlacePackage> missionPlacePackages) {
        this.missionPlacePackages = missionPlacePackages;
    }

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public List<MissionChallenge> getMissionChallenges() {
        return missionChallenges;
    }

    public void setMissionChallenges(List<MissionChallenge> missionChallenges) {
        this.missionChallenges = missionChallenges;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getSubMissionList() {
        return subMissionList;
    }

    public void setSubMissionList(String subMissionList) {
        this.subMissionList = subMissionList;
    }

    public Integer getMissionPackageId() {
        return missionPackageId;
    }

    public void setMissionPackageId(Integer missionPackageId) {
        this.missionPackageId = missionPackageId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
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
}
