package com.xks.parkjicha.bean;

/**
 * Created by Anxiaomo on 2016/11/9.
 */
public class UnionPayResBean {
    private String status;

    public UnionPayResBean() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UnionPayResBean{" +
                "status='" + status + '\'' +
                '}';
    }
}
