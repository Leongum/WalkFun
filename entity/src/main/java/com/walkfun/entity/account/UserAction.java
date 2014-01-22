package com.walkfun.entity.account;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-1-22
 * Time: 下午10:40
 * To change this template use File | Settings | File Templates.
 */
public class UserAction {

    private Integer actionFromId;
    private String actionFromName;
    private Integer actionToId;
    private String actionToName;
    private Integer actionId;
    private String actionName;
    private Date updateTime;

    public Integer getActionFromId() {
        return actionFromId;
    }

    public void setActionFromId(Integer actionFromId) {
        this.actionFromId = actionFromId;
    }

    public String getActionFromName() {
        return actionFromName;
    }

    public void setActionFromName(String actionFromName) {
        this.actionFromName = actionFromName;
    }

    public Integer getActionToId() {
        return actionToId;
    }

    public void setActionToId(Integer actionToId) {
        this.actionToId = actionToId;
    }

    public String getActionToName() {
        return actionToName;
    }

    public void setActionToName(String actionToName) {
        this.actionToName = actionToName;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
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
