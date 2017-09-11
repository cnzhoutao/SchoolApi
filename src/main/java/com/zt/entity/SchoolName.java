package com.zt.entity;

import java.io.Serializable;

public class SchoolName implements Serializable{

    private int id;
    private int pId;
    private String scName;

    public SchoolName() {
    }

    @Override
    public String toString() {
        return "SchoolName{" +
                "id=" + id +
                ", pId=" + pId +
                ", schName='" + scName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }
}
