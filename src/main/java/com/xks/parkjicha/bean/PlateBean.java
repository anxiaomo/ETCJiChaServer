package com.xks.parkjicha.bean;

/**
 * Created by QFJiang on 2016/8/25.
 */
public class PlateBean
{
	private String platenum;
	private byte platecolor;
	private String block;
	private String parknum;
	private double X;
	private double Y;
	private  double total;
	private boolean flag;

	public PlateBean() {

	}

	public void setTotal(double total) {
		this.total = total;
	}


	public PlateBean(String platenum, byte platecolor, String block, String parknum, double x, double y, boolean flag)
	{
		this.platenum = platenum;
		this.platecolor = platecolor;
		this.block = block;
		this.parknum = parknum;
		X = x;
		Y = y;
		this.flag=flag;
	}

	public String getPlatenum()
	{
		return platenum;
	}

	public void setPlatenum(String platenum)
	{
		this.platenum = platenum;
	}

	public byte getPlatecolor()
	{
		return platecolor;
	}

	public void setPlatecolor(byte platecolor)
	{
		this.platecolor = platecolor;
	}


	public String getParknum()
	{
		return parknum;
	}

	public void setParknum(String parknum)
	{
		this.parknum = parknum;
	}

	public double getX()
	{
		return X;
	}

	public void setX(double x)
	{
		X = x;
	}

	public double getY()
	{
		return Y;
	}

	public void setY(double y)
	{
		Y = y;
	}


	@Override
	public String toString()
	{
		return "PlateBean{" +
				"platenum='" + platenum + '\'' +
				", platecolor='" + platecolor + '\'' +
				", block='" + block + '\'' +
				", parknum='" + parknum + '\'' +
				", X=" + X +
				", Y=" + Y +
				", total=" + total +
				'}';
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
