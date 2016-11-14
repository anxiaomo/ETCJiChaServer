package com.xks.parkjicha.bean;

/**
 * Created by Administrator on 2016/9/11.
 */
public class MergeRecordRspBean
{
    private String serialNum;

    private double total;

    public MergeRecordRspBean() {
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MergeRecordRspBean{" +
                "serialNum='" + serialNum + '\'' +
                ", total=" + total +
                '}';
    }
}
