package com.zt.model;

import com.zt.entity.DetailImg;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InviWithDetailImg implements Serializable {

    private long id;
    private int type;//帖子类别
    private String title;//帖子标题
    private String content;//帖子内容
    private int likeNum;//用户喜欢数
    private Date creTime;//创建时间
    private int jugeNum;//用户评论数
    private int userId;//用户id
    private String userName;//用户名
    private String userIcon;//用户头像
    private long viewNum;
    List<DetailImg> detailImgs;



    public InviWithDetailImg() {
    }


    @Override
    public String toString() {
        return "InviWithDetailImg{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", likeNum=" + likeNum +
                ", creTime=" + creTime +
                ", jugeNum=" + jugeNum +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", viewNum=" + viewNum +
                ", detailImgs=" + detailImgs +
                '}';
    }

    public long getViewNum() {
        return viewNum;
    }

    public void setViewNum(long viewNum) {
        this.viewNum = viewNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }

    public int getJugeNum() {
        return jugeNum;
    }

    public void setJugeNum(int jugeNum) {
        this.jugeNum = jugeNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public List<DetailImg> getDetailImgs() {
        return detailImgs;
    }

    public void setDetailImgs(List<DetailImg> detailImgs) {
        this.detailImgs = detailImgs;
    }
}
