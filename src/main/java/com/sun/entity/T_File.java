package com.sun.entity;

public class T_File {

	private int id;
	private String name;
	private String path;
	public T_File() {
		super();
	}
	public T_File(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
