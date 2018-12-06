package com.sun.entity;


import java.util.Date;
import java.util.List;


/**
 * 导航栏的三级菜单,从属于导航栏二级菜单,只针对‘活动专区’栏目
 * @author asus
 *
 */

public class ThreeBar {

	private int id;
	private String name;
	private Date huoDongStart;//活动开始时间
	private Date huoDongOver;//活动结束时间
	private String carousel;//1=大类活动专区下的轮播图片的显示
	private Date carouselXh;//轮播图片的排序
	private String carouselTplj;//轮播图片的路径
	private int twoBarId;//导航条二级类id
	private TwoBar twoBar;
	
	private List<HuoDong> huoDongList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getHuoDongStart() {
		return huoDongStart;
	}
	public void setHuoDongStart(Date huoDongStart) {
		this.huoDongStart = huoDongStart;
	}
	public Date getHuoDongOver() {
		return huoDongOver;
	}
	public void setHuoDongOver(Date huoDongOver) {
		this.huoDongOver = huoDongOver;
	}
	public String getCarousel() {
		return carousel;
	}
	public void setCarousel(String carousel) {
		this.carousel = carousel;
	}
	public Date getCarouselXh() {
		return carouselXh;
	}
	public void setCarouselXh(Date carouselXh) {
		this.carouselXh = carouselXh;
	}
	public String getCarouselTplj() {
		return carouselTplj;
	}
	public void setCarouselTplj(String carouselTplj) {
		this.carouselTplj = carouselTplj;
	}
	public int getTwoBarId() {
		return twoBarId;
	}
	public void setTwoBarId(int twoBarId) {
		this.twoBarId = twoBarId;
	}
	public TwoBar getTwoBar() {
		return twoBar;
	}
	public void setTwoBar(TwoBar twoBar) {
		this.twoBar = twoBar;
	}
	public List<HuoDong> getHuoDongList() {
		return huoDongList;
	}
	public void setHuoDongList(List<HuoDong> huoDongList) {
		this.huoDongList = huoDongList;
	}
	
	
	
}
