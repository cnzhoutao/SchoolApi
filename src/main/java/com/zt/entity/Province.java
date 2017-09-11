package com.zt.entity;

import java.io.Serializable;

/**
 * 省
 */
public class Province implements Serializable {

    private int id;
    private String pName;

    public Province() {
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + pName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
