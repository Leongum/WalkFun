package com.walkfun.entity.common;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-3-20
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
public class FightDefinition {

    private Integer id;
    private Integer inUsing;
    private String fName;
    private Double minLimit;
    private Double maxLimit;
    private String mName;
    private String mLevel;
    private Double mMaxFight;
    private Double mMinFight;
    private Double bPower;
    private Double bGold;
    private Double bExperience;
    private String fWin;
    private String winGot;
    private String winRule;
    private String fLoose;
    private String tProb;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInUsing() {
        return inUsing;
    }

    public void setInUsing(Integer inUsing) {
        this.inUsing = inUsing;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Double getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Double minLimit) {
        this.minLimit = minLimit;
    }

    public Double getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Double maxLimit) {
        this.maxLimit = maxLimit;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLevel() {
        return mLevel;
    }

    public void setmLevel(String mLevel) {
        this.mLevel = mLevel;
    }

    public Double getmMaxFight() {
        return mMaxFight;
    }

    public void setmMaxFight(Double mMaxFight) {
        this.mMaxFight = mMaxFight;
    }

    public Double getmMinFight() {
        return mMinFight;
    }

    public void setmMinFight(Double mMinFight) {
        this.mMinFight = mMinFight;
    }

    public Double getbPower() {
        return bPower;
    }

    public void setbPower(Double bPower) {
        this.bPower = bPower;
    }

    public Double getbGold() {
        return bGold;
    }

    public void setbGold(Double bGold) {
        this.bGold = bGold;
    }

    public Double getbExperience() {
        return bExperience;
    }

    public void setbExperience(Double bExperience) {
        this.bExperience = bExperience;
    }

    public String getfWin() {
        return fWin;
    }

    public void setfWin(String fWin) {
        this.fWin = fWin;
    }

    public String getWinGot() {
        return winGot;
    }

    public void setWinGot(String winGot) {
        this.winGot = winGot;
    }

    public String getWinRule() {
        return winRule;
    }

    public void setWinRule(String winRule) {
        this.winRule = winRule;
    }

    public String getfLoose() {
        return fLoose;
    }

    public void setfLoose(String fLoose) {
        this.fLoose = fLoose;
    }

    public String gettProb() {
        return tProb;
    }

    public void settProb(String tProb) {
        this.tProb = tProb;
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
