package com.sun.entity;


public class SpddMx {
	
	 private int id;
	 private String spdm;//�����ṩ����Ʒ����
	 private String spph;
	 private String spmc;//��Ʒ����
	 private String dw;//��λ
	 private String spgg;//��Ʒ���
	 private float xsjg;//���ۼ۸�
	 private int sl;//����
	 private String ddbh;//����Ķ������
	 private String hdnr;//�����
	 private int fcsl;
	 
	 
	public SpddMx() {
		super();
	}
	
	public SpddMx(String spdm, String spmc, String dw, String spgg, float xsjg, int sl, String ddbh,String hdnr) {
		super();
		this.spdm = spdm;
		this.spmc = spmc;
		this.dw = dw;
		this.spgg = spgg;
		this.xsjg = xsjg;
		this.sl = sl;
		this.ddbh = ddbh;
		this.hdnr=hdnr;
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
	public String getSpmc() {
		return spmc;
	}
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getSpgg() {
		return spgg;
	}
	public void setSpgg(String spgg) {
		this.spgg = spgg;
	}
	public float getXsjg() {
		return xsjg;
	}
	public void setXsjg(float xsjg) {
		this.xsjg = xsjg;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}

	public String getDdbh() {
		return ddbh;
	}

	public void setDdbh(String ddbh) {
		this.ddbh = ddbh;
	}

	public String getHdnr() {
		return hdnr;
	}

	public void setHdnr(String hdnr) {
		this.hdnr = hdnr;
	}

	public int getFcsl() {
		return fcsl;
	}

	public void setFcsl(int fcsl) {
		this.fcsl = fcsl;
	}
	
	 
}
