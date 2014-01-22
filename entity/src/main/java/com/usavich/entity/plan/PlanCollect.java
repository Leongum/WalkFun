package com.usavich.entity.plan;

import com.usavich.common.lib.CustomDateDeserializer;
import com.usavich.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-8
 * Time: 下午2:22
 * To change this template use File | Settings | File Templates.
 */
public class PlanCollect {

    private Integer userId;
    private Integer planId;
    private Date collectTime;
    private Integer collectStatus; //0 collected 1 deleted.

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCollectTime() {
        return collectTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Integer getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(Integer collectStatus) {
        this.collectStatus = collectStatus;
    }
}
