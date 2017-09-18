package com.zt.entity;

import java.io.Serializable;

public class DetailImg implements Serializable {

    private long id;
    private long inviId;//细节图对应的帖子id
    private String imgUrl;//细节图对应的图片名称

    public DetailImg() {
    }

    @Override
    public String toString() {
        return "DetailImg{" +
                "id=" + id +
                ", inviId=" + inviId +
                ", imgUrl='" + imgUrl + '\'' +
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
