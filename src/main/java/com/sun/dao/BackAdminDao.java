package com.sun.dao;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Admin;

public interface BackAdminDao {
	
	/**
	 * ��̨��¼
	 * @param admin
	 * @return
	 */
	public Admin login(@Param("userName")String userName);

}
