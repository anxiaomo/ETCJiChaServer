package com.xks.parkjicha.bean;

/**
 * Created by QFJiang on 2016/8/25.
 */
public class RecordBean
{
	private String serialnum;
	private String arreartype;
	private String roadname;
	private String parknum;
	private long timein;
	private long timeleave;
	private int purchaseamount;
	private int arrearamount;
	private int parkfee;
	private int penalty;

	public RecordBean(String serialnum, String arreartype, String roadname, String parknum, long timein, long timeleave, int purchaseamount, int arrearamount, int parkfee, int penalty)
	{
		this.serialnum = serialnum;
		this.arreartype = arreartype;
		this.roadname = roadname;
		this.parknum = parknum;
		this.timein = timein;
		this.timeleave = timeleave;
		this.purchaseamount = purchaseamount;
		this.arrearamount = arrearamount;
		this.parkfee = parkfee;
		this.penalty = penalty;
	}

	public String getSerialnum()
	{
		return serialnum;
	}

	public void setSerialnum(String serialnum)
	{
		this.serialnum = serialnum;
	}

	public String getArreartype()
	{
		return arreartype;
	}

	public void setArreartype(String arreartype)
	{
		this.arreartype = arreartype;
	}

	public String getRoadname()
	{
		return roadname;
	}

	public void setRoadname(String roadname)
	{
		this.roadname = roadname;
	}

	public String getParknum()
	{
		return parknum;
	}

	public void setParknum(String parknum)
	{
		this.parknum = parknum;
	}

	public long getTimein()
	{
		return timein;
	}

	public void setTimein(long timein)
	{
		this.timein = timein;
	}

	public long getTimeleave()
	{
		return timeleave;
	}

	public void setTimeleave(long timeleave)
	{
		this.timeleave = timeleave;
	}

	public int getPurchaseamount()
	{
		return purchaseamount;
	}

	public void setPurchaseamount(int purchaseamount)
	{
		this.purchaseamount = purchaseamount;
	}

	public int getArrearamount()
	{
		return arrearamount;
	}

	public void setArrearamount(int arrearamount)
	{
		this.arrearamount = arrearamount;
	}

	public int getParkfee()
	{
		return parkfee;
	}

	public void setParkfee(int parkfee)
	{
		this.parkfee = parkfee;
	}

	public int getPenalty()
	{
		return penalty;
	}

	public void setPenalty(int penalty)
	{
		this.penalty = penalty;
	}

	@Override
	public String toString()
	{
		return "RecordBean{" +
				"serialnum='" + serialnum + '\'' +
				", arreartype='" + arreartype + '\'' +
				", roadname='" + roadname + '\'' +
				", parknum='" + parknum + '\'' +
				", timein=" + timein +
				", timeleave=" + timeleave +
				", purchaseamount=" + purchaseamount +
				", arrearamount=" + arrearamount +
				", parkfee=" + parkfee +
				", penalty=" + penalty +
				'}';
	}
}
