package com.sun.dao;

import java.util.List;

import com.sun.entity.NavigationBar;

public interface NavigationBarDao {

	/**
	 * 查询全部信息
	 * @return
	 */
	public List<NavigationBar> finList();
	
	/**
	 * 首页推荐品种和最新活动
	 * @return
	 */
	public List<NavigationBar> hdatj();
}
