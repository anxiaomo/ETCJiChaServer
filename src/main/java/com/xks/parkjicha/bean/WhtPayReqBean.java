package com.xks.parkjicha.bean;

/**
 * Created by Anxiaomo on 2016/11/9.
 */
public class WhtPayReqBean {
    private String platinum;
    private String serialnum;
    private String terminalnum;
    private String dealtime;
    private String terminalserialnum;
    private String logiccardnum;
    private String physiccardnum;
    private String lastterminalnum;
    private String lastdealtime;
    private int dealamount;
    private int balance;
    private String onlinetimes;
    private String offlinetimes;
    private String dealauthcode;

    public WhtPayReqBean() {
    }


    public String getPlatinum() {
        return platinum;
    }

    public void setPlatinum(String platinum) {
        this.platinum = platinum;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    public String getTerminalnum() {
        return terminalnum;
    }

    public void setTerminalnum(String terminalnum) {
        this.terminalnum = terminalnum;
    }

    public String getDealtime() {
        return dealtime;
    }

    public void setDealtime(String dealtime) {
        this.dealtime = dealtime;
    }

    public String getTerminalserialnum() {
        return terminalserialnum;
    }

    public void setTerminalserialnum(String terminalserialnum) {
        this.terminalserialnum = terminalserialnum;
    }

    public String getLogiccardnum() {
        return logiccardnum;
    }

    public void setLogiccardnum(String logiccardnum) {
        this.logiccardnum = logiccardnum;
    }

    public String getPhysiccardnum() {
        return physiccardnum;
    }

    public void setPhysiccardnum(String physiccardnum) {
        this.physiccardnum = physiccardnum;
    }

    public String getLastterminalnum() {
        return lastterminalnum;
    }

    public void setLastterminalnum(String lastterminalnum) {
        this.lastterminalnum = lastterminalnum;
    }

    public String getLastdealtime() {
        return lastdealtime;
    }

    public void setLastdealtime(String lastdealtime) {
        this.lastdealtime = lastdealtime;
    }

    public int getDealamount() {
        return dealamount;
    }

    public void setDealamount(int dealamount) {
        this.dealamount = dealamount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getOnlinetimes() {
        return onlinetimes;
    }

    public void setOnlinetimes(String onlinetimes) {
        this.onlinetimes = onlinetimes;
    }

    public String getOfflinetimes() {
        return offlinetimes;
    }

    public void setOfflinetimes(String offlinetimes) {
        this.offlinetimes = offlinetimes;
    }

    public String getDealauthcode() {
        return dealauthcode;
    }

    public void setDealauthcode(String dealauthcode) {
        this.dealauthcode = dealauthcode;
    }

    @Override
    public String toString() {
        return "WhtPayReqBean{" +
                "platinum='" + platinum + '\'' +
                ", serialnum='" + serialnum + '\'' +
                ", terminalnum='" + terminalnum + '\'' +
                ", dealtime='" + dealtime + '\'' +
                ", terminalserialnum='" + terminalserialnum + '\'' +
                ", logiccardnum='" + logiccardnum + '\'' +
                ", physiccardnum='" + physiccardnum + '\'' +
                ", lastterminalnum='" + lastterminalnum + '\'' +
                ", lastdealtime='" + lastdealtime + '\'' +
                ", dealamount=" + dealamount +
                ", balance=" + balance +
                ", onlinetimes='" + onlinetimes + '\'' +
                ", offlinetimes='" + offlinetimes + '\'' +
                ", dealauthcode='" + dealauthcode + '\'' +
                '}';
    }
}
