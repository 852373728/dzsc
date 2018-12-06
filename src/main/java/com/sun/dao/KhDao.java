package com.sun.dao;


import java.util.Map;

import com.sun.entity.Kh;

public interface KhDao {

	/**
	 * 客户注册
	 * @param kh
	 */
	public void add(Kh kh);
	
	/**
	 * 查询客户
	 * @param map
	 * @return
	 */
	public Kh find(Kh kh);
	
	/**
	 * 具有购买权限的用户
	 * @param kh
	 * @return
	 */
	public Kh buyPermissions(Kh kh);
	
	/**
	 * 修改密码
	 * @param map
	 */
	public void editPwd(Map<String, Object> map);
	
}
