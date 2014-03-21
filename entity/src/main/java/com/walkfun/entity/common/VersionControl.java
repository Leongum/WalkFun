package com.walkfun.entity.common;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 5/28/13
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class VersionControl {

    private String platform;

    private Integer version;

    private Integer subVersion;

    private String description;

    private Date systemTime;

    private Date missionLastUpdateTime;

    private Date fightDefineUpdateTime;

    private Date recommendLastUpdateTime;

    private Date productLastUpdateTime;

    private Date actionDefineUpdateTime;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getSubVersion() {
        return subVersion;
    }

    public void setSubVersion(Integer subVersion) {
        this.subVersion = subVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getSystemTime() {
        return systemTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getMissionLastUpdateTime() {
        return missionLastUpdateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setMissionLastUpdateTime(Date missionLastUpdateTime) {
        this.missionLastUpdateTime = missionLastUpdateTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getFightDefineUpdateTime() {
        return fightDefineUpdateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setFightDefineUpdateTime(Date fightDefineUpdateTime) {
        this.fightDefineUpdateTime = fightDefineUpdateTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getRecommendLastUpdateTime() {
        return recommendLastUpdateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setRecommendLastUpdateTime(Date recommendLastUpdateTime) {
        this.recommendLastUpdateTime = recommendLastUpdateTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getProductLastUpdateTime() {
        return productLastUpdateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setProductLastUpdateTime(Date productLastUpdateTime) {
        this.productLastUpdateTime = productLastUpdateTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getActionDefineUpdateTime() {
        return actionDefineUpdateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setActionDefineUpdateTime(Date actionDefineUpdateTime) {
        this.actionDefineUpdateTime = actionDefineUpdateTime;
    }
}
