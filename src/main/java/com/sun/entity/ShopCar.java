package com.sun.entity;


public class ShopCar {

	 private int id;
	 private String spdm;//�ڲ���Ʒ����
	 private String spph;//��Ʒ����
	 private int num;//����
	 private String username;//�û�����
	 private Spk spk;
	
	public ShopCar() {
		super();
	}

	public ShopCar(String spdm, int num, String username) {
		super();
		this.spdm = spdm;
		this.num = num;
		this.username = username;
	}
	
	public ShopCar(String spdm, String spph, int num, String username) {
		super();
		this.spdm = spdm;
		this.spph = spph;
		this.num = num;
		this.username = username;
	}

	public String getSpph() {
		return spph;
	}

	public void setSpph(String spph) {
		this.spph = spph;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Spk getSpk() {
		return spk;
	}

	public void setSpk(Spk spk) {
		this.spk = spk;
	}
	
	 
	 
	 
}
