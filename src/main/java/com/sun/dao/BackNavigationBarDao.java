package com.sun.dao;


import com.sun.entity.NavigationBar;

public interface BackNavigationBarDao {

	/**
	 * 根据id获得实体
	 * @param id
	 * @return
	 */
	public NavigationBar getOne(Integer id);
}
