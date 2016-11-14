package com.xks.parkjicha.bean;

import java.util.ArrayList;

/**
 * Created by QFJiang on 2016/8/25.
 */
public class ChooseReqBean
{
	private String workerid;
	private ArrayList<String> blocks;

	public ChooseReqBean() {
	}

	public ChooseReqBean(String workerid, ArrayList<String> blocks)
	{
		this.workerid = workerid;
		this.blocks = blocks;
	}

	public String getWorkerid()
	{
		return workerid;
	}

	public void setWorkerid(String workerid)
	{
		this.workerid = workerid;
	}

	public ArrayList<String> getBlocks()
	{
		return blocks;
	}

	public void setBlocks(ArrayList<String> blocks)
	{
		this.blocks = blocks;
	}

	@Override
	public String toString()
	{
		return "ChooseReqBean{" +
				"workerid='" + workerid + '\'' +
				", blocks=" + blocks +
				'}';
	}
}
