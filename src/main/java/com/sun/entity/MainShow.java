package com.sun.entity;

/**
 * 首页的热点，轮播，感兴趣，首页三张图片四个栏目。
 * @author asus
 *
 */

public class MainShow {
	
	private int id;
	private String sywzdm;//首页位置代码  1=热点，2=轮播，3=感兴趣，4=三张图片
	private String sywzmc;//首页位置名称
	private String tplj;//商品图片路径
	private String backcolor;//背景色
	private int xh;//序号，展示的顺序
	private Integer spkid;//商品库的主键id
	private Spk spk;
	private String searchName;//后台用来查询的临时字段
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSywzdm() {
		return sywzdm;
	}
	public void setSywzdm(String sywzdm) {
		this.sywzdm = sywzdm;
	}
	public String getSywzmc() {
		return sywzmc;
	}
	public void setSywzmc(String sywzmc) {
		this.sywzmc = sywzmc;
	}
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	public String getTplj() {
		return tplj;
	}
	public void setTplj(String tplj) {
		this.tplj = tplj;
	}
	public String getBackcolor() {
		return backcolor;
	}
	public void setBackcolor(String backcolor) {
		this.backcolor = backcolor;
	}
	public Integer getSpkid() {
		return spkid;
	}
	public void setSpkid(Integer spkid) {
		this.spkid = spkid;
	}
	public Spk getSpk() {
		return spk;
	}
	public void setSpk(Spk spk) {
		this.spk = spk;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	
	
}
