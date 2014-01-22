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
 * Time: 下午5:19
 * To change this template use File | Settings | File Templates.
 */
public class PlanUserFollow {

    private Integer userId;
    private Integer followUserId;
    private Integer status;
    private Date addTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Integer followUserId) {
        this.followUserId = followUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getAddTime() {
        return addTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
