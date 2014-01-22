package com.walkfun.entity.mission;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 8/5/13
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class MissionChallenge {

    private Integer challengeId;
    private String grade;
    private BigInteger time;
    private Double distance;
    private Integer sequence;
    private String note;
    private String sex;
    private String rule;

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public BigInteger getTime() {
        return time;
    }

    public void setTime(BigInteger time) {
        this.time = time;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
