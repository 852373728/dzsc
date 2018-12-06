package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.UserCenter;

public interface UserCenterDao {

	/**
	 * 根据父Id查询，tree型,返回list
	 * @param map
	 * @return
	 */
	public List<UserCenter> listByParentId(Map<String, Object> map);
	
	/**
	 * 返回实体
	 * @param map
	 * @return
	 */
	public UserCenter getOne(Map<String, Object> map);
	
	/**
	 * 根据id集合查询list
	 * @param list
	 * @return
	 */
	public List<String> listByID(List<Integer> list);
	
}
