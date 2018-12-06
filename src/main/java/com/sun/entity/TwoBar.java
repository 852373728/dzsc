package com.sun.entity;

import java.util.List;

public class TwoBar {

	private int id;
	private String name;
	private int xh;
	private int barId;//µ¼º½ÌõID
	private List<TuiJian> tuiJianList;
	private List<HuoDong> huoDongList;
	private TuiJian tuiJian;
	private NavigationBar navigationBar;
	
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
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	public int getBarId() {
		return barId;
	}
	public void setBarId(int barId) {
		this.barId = barId;
	}
	public List<TuiJian> getTuiJianList() {
		return tuiJianList;
	}
	public void setTuiJianList(List<TuiJian> tuiJianList) {
		this.tuiJianList = tuiJianList;
	}
	public List<HuoDong> getHuoDongList() {
		return huoDongList;
	}
	public void setHuoDongList(List<HuoDong> huoDongList) {
		this.huoDongList = huoDongList;
	}
	public TuiJian getTuiJian() {
		return tuiJian;
	}
	public void setTuiJian(TuiJian tuiJian) {
		this.tuiJian = tuiJian;
	}
	public NavigationBar getNavigationBar() {
		return navigationBar;
	}
	public void setNavigationBar(NavigationBar navigationBar) {
		this.navigationBar = navigationBar;
	}
	
	
}
