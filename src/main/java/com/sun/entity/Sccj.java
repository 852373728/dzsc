package com.sun.entity;

import java.util.List;

public class Sccj {

	private int id;
	private String cjmc;
	private String cjdm;
	private String show;//1=用于可供页面厂家条件搜索时,推荐页面更多，活动专区更多页面
	private int xh;//排序
	private String splbDm;//用于首页药品等栏目下厂家展示
	private String cjjj;//厂家简介
	private String tplj;//图片路径
	private String tuijianShow;//1=推荐品种页面厂家显示
	private int tuijianxh;//推荐品种页面厂家排序
	private String pinpaiShow;//1=品牌专区上面的的显示
	private int pinpaixh;//品牌专区上面的排序
	private String spdmList;//品牌专区要展示的商品 
	
	
	private List<Spk> spkList;
	private Long spkTotal;//每个厂家含有多少商品，通过sql语句查询出
	private SpkLb spkLb;
	
	
	public String getSpdmList() {
		return spdmList;
	}
	public void setSpdmList(String spdmList) {
		this.spdmList = spdmList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCjmc() {
		return cjmc;
	}
	public void setCjmc(String cjmc) {
		this.cjmc = cjmc;
	}
	public String getCjdm() {
		return cjdm;
	}
	public void setCjdm(String cjdm) {
		this.cjdm = cjdm;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	
	public String getSplbDm() {
		return splbDm;
	}
	public void setSplbDm(String splbDm) {
		this.splbDm = splbDm;
	}
	public String getCjjj() {
		return cjjj;
	}
	public void setCjjj(String cjjj) {
		this.cjjj = cjjj;
	}
	public String getTplj() {
		return tplj;
	}
	public void setTplj(String tplj) {
		this.tplj = tplj;
	}
	public String getTuijianShow() {
		return tuijianShow;
	}
	public void setTuijianShow(String tuijianShow) {
		this.tuijianShow = tuijianShow;
	}
	public int getTuijianxh() {
		return tuijianxh;
	}
	public void setTuijianxh(int tuijianxh) {
		this.tuijianxh = tuijianxh;
	}
	public String getPinpaiShow() {
		return pinpaiShow;
	}
	public void setPinpaiShow(String pinpaiShow) {
		this.pinpaiShow = pinpaiShow;
	}
	public int getPinpaixh() {
		return pinpaixh;
	}
	public void setPinpaixh(int pinpaixh) {
		this.pinpaixh = pinpaixh;
	}
	public List<Spk> getSpkList() {
		return spkList;
	}
	public void setSpkList(List<Spk> spkList) {
		this.spkList = spkList;
	}
	public Long getSpkTotal() {
		return spkTotal;
	}
	public void setSpkTotal(Long spkTotal) {
		this.spkTotal = spkTotal;
	}
	public SpkLb getSpkLb() {
		return spkLb;
	}
	public void setSpkLb(SpkLb spkLb) {
		this.spkLb = spkLb;
	}
	
	
}
