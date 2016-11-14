package com.xks.parkjicha.bean;

/**
 * Created by Anxiaomo on 2016/11/9.
 */
public class WhtPayResBean {
    private String status;

    public WhtPayResBean() {
    }

    public WhtPayResBean(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WhtPayResBean{" +
                "status='" + status + '\'' +
                '}';
    }
}
