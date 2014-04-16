package com.walkfun.entity.account;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-1-23
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class FriendSortInfo {

    private Integer friendId;
    private String friendName;
    private String sex;
    private Double level;
    private Double fatness;
    private Double power;
    private Double fight;
    private Double fightPlus;
    private Integer totalFights;
    private Integer fightsWin;
    private Integer totalFriendFights;
    private Integer friendFightWin;

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public Double getFatness() {
        return fatness;
    }

    public void setFatness(Double fatness) {
        this.fatness = fatness;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
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
