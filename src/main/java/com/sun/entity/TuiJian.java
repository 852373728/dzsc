package com.sun.entity;

public class TuiJian {

	private int id;
	private String sptpljLeft;//用来放推荐品种专区每个类别下最左边的一张图片
	private int xh;
	private String show;//推荐品种： 1:普通的展示，每个二级分类下展示5条，2：推荐品种页面下的每个二级分类的第一个商品展示。
	private String showCarousel;//字段为1时，推荐品种专区轮播图片为显示
	private int xhCarousel;//轮播的排序
	private String sptplj_carousel;//推荐品种专区轮播图片
	private String homePageTuijianCarousel;//1=首页推荐品种栏目左边轮播的图片展示
	private int homePageTuijianCarouselXh;//首页推荐品种栏目左边轮播的图片展示排序
	private String homePageTuijianCarouselTp;//首页推荐品种栏目左边轮播的图片路径
	private String twobarName;//导航条二级类的name
	private int spkId;//商品库Id
	private Spk spk;
	private String searchName;//后台用来搜索的临时字段
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSptpljLeft() {
		return sptpljLeft;
	}
	public void setSptpljLeft(String sptpljLeft) {
		this.sptpljLeft = sptpljLeft;
	}
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String getShowCarousel() {
		return showCarousel;
	}
	public void setShowCarousel(String showCarousel) {
		this.showCarousel = showCarousel;
	}
	public int getXhCarousel() {
		return xhCarousel;
	}
	public void setXhCarousel(int xhCarousel) {
		this.xhCarousel = xhCarousel;
	}
	public String getSptplj_carousel() {
		return sptplj_carousel;
	}
	public void setSptplj_carousel(String sptplj_carousel) {
		this.sptplj_carousel = sptplj_carousel;
	}
	public String getHomePageTuijianCarousel() {
		return homePageTuijianCarousel;
	}
	public void setHomePageTuijianCarousel(String homePageTuijianCarousel) {
		this.homePageTuijianCarousel = homePageTuijianCarousel;
	}
	public int getHomePageTuijianCarouselXh() {
		return homePageTuijianCarouselXh;
	}
	public void setHomePageTuijianCarouselXh(int homePageTuijianCarouselXh) {
		this.homePageTuijianCarouselXh = homePageTuijianCarouselXh;
	}
	public String getHomePageTuijianCarouselTp() {
		return homePageTuijianCarouselTp;
	}
	public void setHomePageTuijianCarouselTp(String homePageTuijianCarouselTp) {
		this.homePageTuijianCarouselTp = homePageTuijianCarouselTp;
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
	
	public String getTwobarName() {
		return twobarName;
	}
	public void setTwobarName(String twobarName) {
		this.twobarName = twobarName;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	
	
}
