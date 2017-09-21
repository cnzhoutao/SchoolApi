package com.zt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子评论表对应的实体类
 */
public class JugeInvi implements Serializable {

    private long id;
    private long inviId;
    private long userId;
    private String userName;
    private String userIcon;
    private String content;
    private Date cretTime;

    public JugeInvi() {
    }

    @Override
    public String toString() {
        return "JugeInVi{" +
                "id=" + id +
                ", inviId=" + inviId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", content='" + content + '\'' +
                ", cretTime=" + cretTime +
                '}';
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCretTime() {
        return cretTime;
    }

    public void setCretTime(Date cretTime) {
        this.cretTime = cretTime;
    }
}
