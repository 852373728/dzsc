package com.sun.entity;
/**
 * 用于首页药品等栏目下的各种商品展示
 * @author sunqilin
 *
 */
public class MainTypeShow {
	
	private int id;
	private String homePageshow;//用来确定商品库的商品是在首页显示1=二级分类下的四个商品展示。2=一级分类下的一张图片展示，就是最左边的那张图片，3=大家都在找的商品展示，最多展示四条
 	private String onePicTplj;//用于一级分类下的图片路径，就是最左边的那张特殊的图片
 	private int homePagexh;
 	private String splbDm;
 	private int spkId;
 	private Spk spk;
 	private String searchName;
 	private SpkLb spkLb;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHomePageshow() {
		return homePageshow;
	}
	public void setHomePageshow(String homePageshow) {
		this.homePageshow = homePageshow;
	}
	public String getOnePicTplj() {
		return onePicTplj;
	}
	public void setOnePicTplj(String onePicTplj) {
		this.onePicTplj = onePicTplj;
	}
	public int getHomePagexh() {
		return homePagexh;
	}
	public void setHomePagexh(int homePagexh) {
		this.homePagexh = homePagexh;
	}
	public String getSplbDm() {
		return splbDm;
	}
	public void setSplbDm(String splbDm) {
		this.splbDm = splbDm;
	}
	public int getSpkId() {
		return spkId;
	}
	public void setSpkId(int spkId) {
		this.spkId = spkId;
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
	public SpkLb getSpkLb() {
		return spkLb;
	}
	public void setSpkLb(SpkLb spkLb) {
		this.spkLb = spkLb;
	}
	
 	
}
