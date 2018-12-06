package com.sun.entity;

public class Roles_permissions {
	
	private int id;
	private String rolesName;
	private int usercenterId;
	public Roles_permissions() {
		super();
	}
	
	public Roles_permissions(String rolesName, int usercenterId) {
		super();
		this.rolesName = rolesName;
		this.usercenterId = usercenterId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolesName() {
		return rolesName;
	}
	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}
	public int getUsercenterId() {
		return usercenterId;
	}
	public void setUsercenterId(int usercenterId) {
		this.usercenterId = usercenterId;
	}
	
	

}
