package com.sun.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Kh;

public interface BackKhDao {

	/**
	 * ��̨list
	 * @param map
	 * @return
	 */
	public List<Kh> list(Map<String, Object> map);
	
	/**
	 * ��̨����
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public void update(Kh kh);
	
	public void delete(@Param("email")String email);
}
