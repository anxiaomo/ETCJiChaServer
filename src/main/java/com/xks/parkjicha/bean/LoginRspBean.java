package com.xks.parkjicha.bean;

import java.util.ArrayList;

/**
 * Created by QFJiang on 2016/8/25.
 */
public class LoginRspBean
{
	private String token;
	private ArrayList<BlockBean>blocks;

	public LoginRspBean() {
	}

	public LoginRspBean(String token, ArrayList<BlockBean> blocks) {
		this.token = token;
		this.blocks = blocks;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ArrayList<BlockBean> getBlocks() {
		return blocks;
	}

	public void setBlocks(ArrayList<BlockBean> blocks) {
		this.blocks = blocks;
	}

	@Override
	public String toString() {
		return "LoginRspBean{" +
				"token='" + token + '\'' +
				", blocks=" + blocks +
				'}';
	}
}
