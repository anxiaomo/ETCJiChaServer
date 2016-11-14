package com.xks.parkjicha.bean;

/**
 * Created by Anxiaomo on 2016/11/13.
 */
public class PlateReqBean {
    private long lasttime;

    public PlateReqBean() {
    }

    public long getLasttime() {
        return lasttime;
    }

    public void setLasttime(long lasttime) {
        this.lasttime = lasttime;
    }

    @Override
    public String toString() {
        return "PlateReqBean{" +
                "lasttime=" + lasttime +
                '}';
    }
}
