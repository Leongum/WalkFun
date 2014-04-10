package com.walkfun.entity.account;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

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
    private String userTitle;
    private String userTitlePic;
    private Double fatness;
    private Double power;
    private Double fight;
    private Double fightPlus;

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

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getUserTitlePic() {
        return userTitlePic;
    }

    public void setUserTitlePic(String userTitlePic) {
        this.userTitlePic = userTitlePic;
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
}
