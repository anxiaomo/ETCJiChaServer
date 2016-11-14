package com.xks.parkjicha.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/11.
 */
public class MergeRecordReqBean
{
    private String platenum;
    private Byte platecolor;
    private ArrayList<RecordBean> records;

    public MergeRecordReqBean() {
    }

    public String getPlatenum() {
        return platenum;
    }

    public void setPlatenum(String platenum) {
        this.platenum = platenum;
    }

    public Byte getPlatecolor() {
        return platecolor;
    }

    public void setPlatecolor(Byte platecolor) {
        this.platecolor = platecolor;
    }

    public ArrayList<RecordBean> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<RecordBean> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "MergeRecordReqBean{" +
                "platenum='" + platenum + '\'' +
                ", platecolor=" + platecolor +
                ", records=" + records +
                '}';
    }
}
