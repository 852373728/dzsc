package com.sun.entity;

import java.util.List;

public class NavigationBar {

	private int id;
	private String name;
	private String url;
	private String urlName;//√Ë ˆ
	private int xh;
	private List<TwoBar> twoBarList;
	private List<TuiJian> tuiJianList;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	public List<TwoBar> getTwoBarList() {
		return twoBarList;
	}
	public void setTwoBarList(List<TwoBar> twoBarList) {
		this.twoBarList = twoBarList;
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
	
	
}
