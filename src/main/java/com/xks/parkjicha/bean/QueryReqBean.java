package com.xks.parkjicha.bean;

/**
 * Created by QFJiang on 2016/8/28.
 */
public class QueryReqBean
{
	private String platenum;

	private byte platecolor;

	private int pagenum;

	public QueryReqBean() {
	}

	public String getPlatenum() {
		return platenum;
	}

	public void setPlatenum(String platenum) {
		this.platenum = platenum;
	}

	public byte getPlatecolor() {
		return platecolor;
	}

	public void setPlatecolor(byte platecolor) {
		this.platecolor = platecolor;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	@Override
	public String toString() {
		return "QueryReqBean{" +
				"platenum='" + platenum + '\'' +
				", platecolor=" + platecolor +
				", pagenum=" + pagenum +
				'}';
	}
}
