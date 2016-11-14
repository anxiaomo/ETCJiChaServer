package com.xks.parkjicha.bean;

import java.util.ArrayList;

/**
 * Created by Anxiaomo on 2016/11/14.
 */
public class PlateRspBean {
    private long thistime;
    private ArrayList<PlateBean> plates;
    public PlateRspBean() {
    }

    public PlateRspBean(long thistime, ArrayList<PlateBean> plates) {
        this.thistime = thistime;
        this.plates = plates;
    }

    public long getThistime() {
        return thistime;
    }

    public void setThistime(long thistime) {
        this.thistime = thistime;
    }

    public ArrayList<PlateBean> getPlates() {
        return plates;
    }

    public void setPlates(ArrayList<PlateBean> plates) {
        this.plates = plates;
    }

    @Override
    public String toString() {
        return "PlateRspBean{" +
                "thistime=" + thistime +
                ", plates=" + plates +
                '}';
    }
}
