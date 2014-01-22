package com.usavich.entity.account;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo extends UserBase {

    private double level;

    private double scores;

    private double experience;

    private double maxPower;

    private double remainingPower;

    private double endurance;

    private double spirit;

    private double rapidly;

    private double recoverSpeed;

    private double weight;

    private double height;

    private Integer age;

    private double totalDistance;
    private double avgSpeed;
    private double spendCarlorie;
    private Integer totalRunTimes;

    //private Date systemTime;

    //private double baseAcc;

    //private double inertiaAcc;

    //private double crit;

    //private double luck;

    public UserInfo() {

    }

    public UserInfo(UserBase userBase) {
        this.setUserId(userBase.getUserId());
        this.setUserEmail(userBase.getUserEmail());
        this.setNickName(userBase.getNickName());
        this.setPassword(userBase.getPassword());
        this.setUuid(userBase.getUuid());
        this.setSex(userBase.getSex());
        this.level = 0;
        this.scores = 0;
        this.experience = 0;
        this.maxPower = 0;
        this.remainingPower = 0;
        this.endurance = 0;
        this.spirit = 0;
        this.rapidly = 0;
        this.recoverSpeed = 0;
        this.totalDistance = 0;
        this.avgSpeed = 0;
        this.spendCarlorie = 0;
        this.totalRunTimes = 0;
        //this.systemTime = new Date();
        //this.baseAcc = 1;
        //this.inertiaAcc = 1;
        //this.crit = 1;
        //this.luck = 1;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
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

    public double getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(double maxPower) {
        this.maxPower = maxPower;
    }

    public double getRemainingPower() {
        return remainingPower;
    }

    public void setRemainingPower(double remainingPower) {
        this.remainingPower = remainingPower;
    }

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public double getSpirit() {
        return spirit;
    }

    public void setSpirit(double spirit) {
        this.spirit = spirit;
    }

    public double getRapidly() {
        return rapidly;
    }

    public void setRapidly(double rapidly) {
        this.rapidly = rapidly;
    }

    public double getRecoverSpeed() {
        return recoverSpeed;
    }

    public void setRecoverSpeed(double recoverSpeed) {
        this.recoverSpeed = recoverSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public double getSpendCarlorie() {
        return spendCarlorie;
    }

    public void setSpendCarlorie(double spendCarlorie) {
        this.spendCarlorie = spendCarlorie;
    }

    public Integer getTotalRunTimes() {
        return totalRunTimes;
    }

    public void setTotalRunTimes(Integer totalRunTimes) {
        this.totalRunTimes = totalRunTimes;
    }
}
