package com.sun.entity;

public class Collect {
	
	private int id;
	private String spdm;//商品代码，唯一标示
	private String userName;//用户账号
	private Spk spk;
	
	public Collect() {
		super();
	}
	
	public Collect(String spdm, String userName) {
		super();
		this.spdm = spdm;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpdm() {
		return spdm;
	}
	public void setSpdm(String spdm) {
		this.spdm = spdm;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Spk getSpk() {
		return spk;
	}
	public void setSpk(Spk spk) {
		this.spk = spk;
	}
	
	

}
