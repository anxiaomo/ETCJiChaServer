package com.xks.parkjicha.bean;

/**
 * Created by Anxiaomo on 2016/11/9.
 */
public class UnionPayReqBean {
    private String userid;
    private String batchnum;
    private String serialnum;
    private String cardid;
    private int realamount;
    private Byte status;

    public UnionPayReqBean() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBatchnum() {
        return batchnum;
    }

    public void setBatchnum(String batchnum) {
        this.batchnum = batchnum;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public int getRealamount() {
        return realamount;
    }

    public void setRealamount(int realamount) {
        this.realamount = realamount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UnionPayReqBean{" +
                "userid='" + userid + '\'' +
                ", batchnum='" + batchnum + '\'' +
                ", serialnum='" + serialnum + '\'' +
                ", cardid='" + cardid + '\'' +
                ", realamount=" + realamount +
                ", status=" + status +
                '}';
    }
}
