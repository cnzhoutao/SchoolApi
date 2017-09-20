package com.zt.entity;

import java.io.Serializable;

/**
 * 帖子收藏表对应的实体类
 */
public class InviSave implements Serializable {

    private long id;
    private long inviId;
    private long userId;
    private String userName;
    private String userIcon;




    public InviSave() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInviId() {
        return inviId;
    }

    public void setInviId(long inviId) {
        this.inviId = inviId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    @Override
    public String toString() {
        return "inviLike{" +
                "id=" + id +
                ", inviId=" + inviId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userIcon='" + userIcon + '\'' +
                '}';
    }

}
