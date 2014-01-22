package com.usavich.entity.account;

import com.usavich.common.lib.CustomDateDeserializer;
import com.usavich.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 5/28/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserLocation extends UserBase {

    private Integer userId;

    private String lastLocationContent;

    private String lastLocationPoint;

    private Date lastActiveTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLastLocationContent() {
        return lastLocationContent;
    }

    public void setLastLocationContent(String lastLocationContent) {
        this.lastLocationContent = lastLocationContent;
    }

    public String getLastLocationPoint() {
        return lastLocationPoint;
    }

    public void setLastLocationPoint(String lastLocationPoint) {
        this.lastLocationPoint = lastLocationPoint;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }
}
