package com.sun.entity;

import java.util.List;

public class UserCenter {
	
	 private int id;
     private String name;
     private int parentId;
     private int state;
     private int xh;
     private List<UserCenter> userCenterList;
     private UserCenter userCenter;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	public List<UserCenter> getUserCenterList() {
		return userCenterList;
	}
	public void setUserCenterList(List<UserCenter> userCenterList) {
		this.userCenterList = userCenterList;
	}
	public UserCenter getUserCenter() {
		return userCenter;
	}
	public void setUserCenter(UserCenter userCenter) {
		this.userCenter = userCenter;
	}
     
     
}
