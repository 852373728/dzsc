package com.sun.dao;


import com.sun.entity.NavigationBar;

public interface BackNavigationBarDao {

	/**
	 * ����id���ʵ��
	 * @param id
	 * @return
	 */
	public NavigationBar getOne(Integer id);
}
