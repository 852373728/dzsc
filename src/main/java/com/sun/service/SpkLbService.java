package com.sun.service;

import java.util.List;

import com.sun.entity.Kh;
import com.sun.entity.SpkLb;

public interface SpkLbService {

	/**
	 * 根据字段lbparent来查询集合，递归查询
	 * @param lbparent
	 * @return
	 */
	public List<SpkLb> findByLbParent(String lbparent);
	
	/**
	 * 用于首页一二级分类查询
	 * @return
	 */
	public List<SpkLb> findLevel(boolean loggedIn,Kh kh);
}
