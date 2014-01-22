package com.usavich.entity.running;

import com.usavich.common.lib.CustomDateDeserializer;
import com.usavich.common.lib.CustomDateSerializer;
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
    private String waveForm;
    private Date missionStartTime;
    private Date missionEndTime;
    private Date missionDate;
    private double spendCarlorie;
    private BigInteger duration;
    private double avgSpeed;
    private Integer steps;
    private double distance;
    private String offerUsers;
    private Integer missionGrade;
    private double scores;
    private double experience;
    private double extraExperience;
    private String comment;
    private Date commitTime;
    private String uuid;
    private Integer grade;
    private Integer valid;
    private String planRunUuid;
    private Integer sequence;
    private String speedList;

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

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
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

    public String getOfferUsers() {
        return offerUsers;
    }

    public void setOfferUsers(String offerUsers) {
        this.offerUsers = offerUsers;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMissionGrade() {
        return missionGrade;
    }

    public void setMissionGrade(Integer missionGrade) {
        this.missionGrade = missionGrade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public String getWaveForm() {
        return waveForm;
    }

    public void setWaveForm(String waveForm) {
        this.waveForm = waveForm;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getPlanRunUuid() {
        return planRunUuid;
    }

    public void setPlanRunUuid(String planRunUuid) {
        this.planRunUuid = planRunUuid;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getSpeedList() {
        return speedList;
    }

    public void setSpeedList(String speedList) {
        this.speedList = speedList;
    }
}
