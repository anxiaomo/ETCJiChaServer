package com.xks.parkjicha.bean;

/**
 * Created by QFJiang on 2016/8/25.
 */
public class LoginReqBean
{
	private String workerid;
	private String password;

	public LoginReqBean() {
	}

	public LoginReqBean(String workerid, String password)
	{
		this.workerid = workerid;
		this.password = password;
	}

	public String getWorkerid()
	{
		return workerid;
	}

	public void setWorkerid(String workerid)
	{
		this.workerid = workerid;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "LoginReqBean{" +
				"workerid='" + workerid + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
