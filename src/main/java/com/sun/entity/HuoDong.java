package com.sun.entity;

import java.util.Date;

public class HuoDong {

	private int id;
	private String huoDongContent;//活动内容
	private String show;//1=活动专区下6个商品的展示
	private int xh;//活动专区下6个商品的排序
	private String show1;//1=首页最新活动下有买有送，返现活动栏目下的5个商品展示;
	private int xh1;//首页最新活动下有买有送，返现活动栏目下的5个商品排序
	private String area;//活动商品只针对某个区域的名称，如果为空，则哪个区域都可以参加活动，以市级为针对
	private String sfyx;//1=该商品的活动正在进行，空=该商品活动未在进行
	private String homePageHuoDongCarousel;//1=首页活动专区栏目左边轮播的图片展示
	private int homePageHuoDongCarouselXh;//首页活动专区栏目左边轮播的图片展示排序
	private String homePageHuoDongCarouselTp;//首页活动专区栏目左边轮播的图片路径
	private Date hdtime;//商品活动结束时间
	private Date startTime;//商品活动开始时间
	
	private int spkId;//商品库ID
	private int twoBarId;//导航条二级分类ID
	private String twoBarName;//导航条二级分类名称
	private int threeBarId;//导航条三级分类ID
	private Spk spk;
	private TwoBar twoBar;
	private ThreeBar threeBar;
	private String searchName;//后台用来搜索的临时字段
	private String huodongover;//临时字段
	
	public Date getHdtime() {
		return hdtime;
	}
	public void setHdtime(Date hdtime) {
		this.hdtime = hdtime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHuoDongContent() {
		return huoDongContent;
	}
	public void setHuoDongContent(String huoDongContent) {
		this.huoDongContent = huoDongContent;
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
	public String getShow1() {
		return show1;
	}
	public void setShow1(String show1) {
		this.show1 = show1;
	}
	public int getXh1() {
		return xh1;
	}
	public void setXh1(int xh1) {
		this.xh1 = xh1;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSfyx() {
		return sfyx;
	}
	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}
	public String getHomePageHuoDongCarousel() {
		return homePageHuoDongCarousel;
	}
	public void setHomePageHuoDongCarousel(String homePageHuoDongCarousel) {
		this.homePageHuoDongCarousel = homePageHuoDongCarousel;
	}
	public int getHomePageHuoDongCarouselXh() {
		return homePageHuoDongCarouselXh;
	}
	public void setHomePageHuoDongCarouselXh(int homePageHuoDongCarouselXh) {
		this.homePageHuoDongCarouselXh = homePageHuoDongCarouselXh;
	}
	public String getHomePageHuoDongCarouselTp() {
		return homePageHuoDongCarouselTp;
	}
	public void setHomePageHuoDongCarouselTp(String homePageHuoDongCarouselTp) {
		this.homePageHuoDongCarouselTp = homePageHuoDongCarouselTp;
	}
	public int getSpkId() {
		return spkId;
	}
	public void setSpkId(int spkId) {
		this.spkId = spkId;
	}
	public int getTwoBarId() {
		return twoBarId;
	}
	public void setTwoBarId(int twoBarId) {
		this.twoBarId = twoBarId;
	}
	public String getTwoBarName() {
		return twoBarName;
	}
	public void setTwoBarName(String twoBarName) {
		this.twoBarName = twoBarName;
	}
	public int getThreeBarId() {
		return threeBarId;
	}
	public void setThreeBarId(int threeBarId) {
		this.threeBarId = threeBarId;
	}
	public Spk getSpk() {
		return spk;
	}
	public void setSpk(Spk spk) {
		this.spk = spk;
	}
	public TwoBar getTwoBar() {
		return twoBar;
	}
	public void setTwoBar(TwoBar twoBar) {
		this.twoBar = twoBar;
	}
	public ThreeBar getThreeBar() {
		return threeBar;
	}
	public void setThreeBar(ThreeBar threeBar) {
		this.threeBar = threeBar;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getHuodongover() {
		return huodongover;
	}
	public void setHuodongover(String huodongover) {
		this.huodongover = huodongover;
	}
	
	
}
