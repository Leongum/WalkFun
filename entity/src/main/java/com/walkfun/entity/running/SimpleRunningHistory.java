package com.walkfun.entity.running;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-13
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
public class SimpleRunningHistory {

    private Integer userId;
    private double spendCarlorie;
    private BigInteger duration;
    private double avgSpeed;
    private Integer steps;
    private double distance;
    private Integer missionGrade;
    private String propGet;
    private Date missionEndTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Integer getMissionGrade() {
        return missionGrade;
    }

    public void setMissionGrade(Integer missionGrade) {
        this.missionGrade = missionGrade;
    }

    public String getPropGet() {
        return propGet;
    }

    public void setPropGet(String propGet) {
        this.propGet = propGet;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getMissionEndTime() {
        return missionEndTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setMissionEndTime(Date missionEndTime) {
        this.missionEndTime = missionEndTime;
    }
}
