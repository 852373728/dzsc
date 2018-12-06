package com.sun.entity;

import com.sun.util.StringUtil;

public class Jinxq {

	private int id;
	private String spdm;
	private String spmc;
	private String spph;
	private String yxq;
	private double kcsl;
	private double ztsl;
	private double kysl;//可用数量
	private double xsjg;//普通的销售价格
	private float cxdj;//促销价格
	private String delbbz;
	private String pict;//图片地址
	private String ylmc;//医保类型
	private String spgg;//商品规格
	private String sccj;//生产厂家
	private String dw;//单位
	private String splb;//所属范围
	private String pzwh;//批准文号
	private int num;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSplb() {
		return splb;
	}
	public void setSplb(String splb) {
		this.splb = splb;
	}
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getSccj() {
		return sccj;
	}
	public void setSccj(String sccj) {
		this.sccj = sccj;
	}
	public String getSpgg() {
		return spgg;
	}
	public void setSpgg(String spgg) {
		this.spgg = spgg;
	}
	public String getYlmc() {
		if(StringUtil.isNotEmpty(ylmc)) {
			if(ylmc.substring(0, 1).equals("甲")) {
				return "甲";
			}else if(ylmc.substring(0, 1).equals("乙")) {
				return "乙";
			}else {
				return "";
			}
		}else {
			return "";
		}
	}
	public void setYlmc(String ylmc) {
		this.ylmc = ylmc;
	}
	public String getPict() {
		return pict;
	}
	public void setPict(String pict) {
		this.pict = pict;
	}
	public double getKysl() {
		return kysl;
	}
	public void setKysl(double kysl) {
		this.kysl = kysl;
	}
	public float getCxdj() {
		return cxdj;
	}
	public void setCxdj(float cxdj) {
		this.cxdj = cxdj;
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
	public String getSpph() {
		return spph;
	}
	public void setSpph(String spph) {
		this.spph = spph;
	}
	public String getYxq() {
		return yxq;
	}
	public void setYxq(String yxq) {
		this.yxq = yxq;
	}
	public double getKcsl() {
		return kcsl;
	}
	public void setKcsl(double kcsl) {
		this.kcsl = kcsl;
	}
	public double getZtsl() {
		return ztsl;
	}
	public void setZtsl(double ztsl) {
		this.ztsl = ztsl;
	}
	public double getXsjg() {
		return xsjg;
	}
	public void setXsjg(double xsjg) {
		this.xsjg = xsjg;
	}
	public String getDelbbz() {
		return delbbz;
	}
	public void setDelbbz(String delbbz) {
		this.delbbz = delbbz;
	}
	
	
	
	
}
