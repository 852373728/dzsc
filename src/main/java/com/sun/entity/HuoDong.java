package com.sun.entity;

import java.util.Date;

public class HuoDong {

	private int id;
	private String huoDongContent;//�����
	private String show;//1=�ר����6����Ʒ��չʾ
	private int xh;//�ר����6����Ʒ������
	private String show1;//1=��ҳ���»���������ͣ����ֻ��Ŀ�µ�5����Ʒչʾ;
	private int xh1;//��ҳ���»���������ͣ����ֻ��Ŀ�µ�5����Ʒ����
	private String area;//���Ʒֻ���ĳ����������ƣ����Ϊ�գ����ĸ����򶼿��Բμӻ�����м�Ϊ���
	private String sfyx;//1=����Ʒ�Ļ���ڽ��У���=����Ʒ�δ�ڽ���
	private String homePageHuoDongCarousel;//1=��ҳ�ר����Ŀ����ֲ���ͼƬչʾ
	private int homePageHuoDongCarouselXh;//��ҳ�ר����Ŀ����ֲ���ͼƬչʾ����
	private String homePageHuoDongCarouselTp;//��ҳ�ר����Ŀ����ֲ���ͼƬ·��
	private Date hdtime;//��Ʒ�����ʱ��
	private Date startTime;//��Ʒ���ʼʱ��
	
	private int spkId;//��Ʒ��ID
	private int twoBarId;//��������������ID
	private String twoBarName;//������������������
	private int threeBarId;//��������������ID
	private Spk spk;
	private TwoBar twoBar;
	private ThreeBar threeBar;
	private String searchName;//��̨������������ʱ�ֶ�
	private String huodongover;//��ʱ�ֶ�
	
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
