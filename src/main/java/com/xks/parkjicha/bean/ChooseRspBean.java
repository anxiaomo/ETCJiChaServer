package com.xks.parkjicha.bean;

/**
 * Created by QFJiang on 2016/8/25.
 */
public class ChooseRspBean
{
	private String status;

	public ChooseRspBean() {
	}

	public ChooseRspBean(String status)
	{
		this.status = status;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "ChooseRspBean{" +
				"status='" + status + '\'' +
				'}';
	}
}
