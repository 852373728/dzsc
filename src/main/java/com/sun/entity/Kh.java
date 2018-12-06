package com.sun.entity;

import java.util.Date;

public class Kh {

	 private int id;
	 private String email;//注册账号
	 private String password;
	 private String dwmc;//单位名称
	 private String lxr;//联系人
	 private String lxdh;//联系电话
	 private String qylx;//企业类型
	 private String sheng;//省
	 private String shi;//市
	 private String adress;//详细地址
	 private String zt;//状态1：正在审核中。2：已通过审核，3:未通过审核，暂时这样
	 private String st_userclass;
	 private Date yxq;
	 private String ywybh;
	 private String ywyxm;
	 private String khdm;
	 
	 
	public Kh() {
		super();
	}
	
	public Kh(String email) {
		super();
		this.email = email;
	}
	public Kh(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email.trim();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password.trim();
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getQylx() {
		return qylx;
	}
	public void setQylx(String qylx) {
		this.qylx = qylx;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getSt_userclass() {
		return st_userclass;
	}
	public void setSt_userclass(String st_userclass) {
		this.st_userclass = st_userclass;
	}
	public Date getYxq() {
		return yxq;
	}
	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}
	public String getYwybh() {
		return ywybh;
	}
	public void setYwybh(String ywybh) {
		this.ywybh = ywybh;
	}
	public String getYwyxm() {
		return ywyxm;
	}
	public void setYwyxm(String ywyxm) {
		this.ywyxm = ywyxm;
	}
	public String getKhdm() {
		return khdm;
	}
	public void setKhdm(String khdm) {
		this.khdm = khdm;
	}
	
	
	 
}
