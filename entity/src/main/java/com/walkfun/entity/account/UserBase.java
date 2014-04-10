package com.walkfun.entity.account;


import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserBase {

    private Integer userId;
    private String uuid;
    private String deviceId;
    private String userName;
    private String password;
    private String nickName;
    private String sex;
    private String platformInfo;
    private Date updateTime;

    public UserBase initUserBase(UserInfo userInfo) {
        UserBase userBase = new UserBase();
        userBase.setUserId(userInfo.getUserId());
        userBase.setUuid(userInfo.getUuid());
        userBase.setDeviceId(userInfo.getDeviceId());
        userBase.setUserName(userInfo.getUserName());
        userBase.setNickName(userInfo.getNickName());
        userBase.setPassword(userInfo.getPassword());
        userBase.setSex(userInfo.getSex());
        userBase.setPlatformInfo(userInfo.getPlatformInfo());
        return userBase;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex == null ? "未知" : sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlatformInfo() {
        return platformInfo;
    }

    public void setPlatformInfo(String platformInfo) {
        this.platformInfo = platformInfo;
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
