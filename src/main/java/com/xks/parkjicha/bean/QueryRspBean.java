package com.xks.parkjicha.bean;

import java.util.ArrayList;

/**
 * Created by QFJiang on 2016/8/28.
 */
public class QueryRspBean
{
	private String status;
	private int recordnum;
	private ArrayList<RecordBean> records;

	public QueryRspBean() {
	}

	public QueryRspBean(String status, int recordnum, ArrayList<RecordBean> records)
	{
		this.status = status;
		this.recordnum = recordnum;
		this.records = records;

	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getRecordnum()
	{
		return recordnum;
	}

	public void setRecordnum(int recordnum)
	{
		this.recordnum = recordnum;
	}

	public ArrayList<RecordBean> getRecords()
	{
		return records;
	}

	public void setRecords(ArrayList<RecordBean> records)
	{
		this.records = records;
	}

	@Override
	public String toString()
	{
		return "QueryRspBean{" +
				"status='" + status + '\'' +
				", recordnum=" + recordnum +
				", records=" + records +
				'}';
	}

}
