package com.walkfun.entity.common;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-16
 * Time: 下午9:35
 * To change this template use File | Settings | File Templates.
 */
public class ActionDefination {

    private Integer actionId;
    private Integer actionType; //0 for run 1 for use
    private Integer inUsing;
    private String actionName;
    private String actionDescription;
    private String actionAttribute;
    private String actionRule;
    private Double triggerProbability;
    private String soundLink;
    private Date updateTime;

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getActionAttribute() {
        return actionAttribute;
    }

    public void setActionAttribute(String actionAttribute) {
        this.actionAttribute = actionAttribute;
    }

    public String getActionRule() {
        return actionRule;
    }

    public void setActionRule(String actionRule) {
        this.actionRule = actionRule;
    }

    public Double getTriggerProbability() {
        return triggerProbability;
    }

    public void setTriggerProbability(Double triggerProbability) {
        this.triggerProbability = triggerProbability;
    }

    public String getSoundLink() {
        return soundLink;
    }

    public void setSoundLink(String soundLink) {
        this.soundLink = soundLink;
    }

    public Integer getInUsing() {
        return inUsing;
    }

    public void setInUsing(Integer inUsing) {
        this.inUsing = inUsing;
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
