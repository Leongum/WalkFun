package com.usavich.entity.account;


/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserBase {

    private Integer userId;

    private String userEmail;

    private String password;

    private String nickName;

    private String sex;

    private String uuid;

    public UserBase initUserBase(UserInfo userInfo) {
        UserBase userBase = new UserBase();
        userBase.setUserId(userInfo.getUserId());
        userBase.setUserEmail(userInfo.getUserEmail());
        userBase.setNickName(userInfo.getNickName());
        userBase.setPassword(userInfo.getPassword());
        userBase.setUuid(userInfo.getUuid());
        userBase.setSex(userInfo.getSex());
        return  userBase;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
