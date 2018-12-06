package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.HuoDong;

public interface BackHuoDongDao {
	
	/**
	 * ��̨list
	 * @param map
	 * @return
	 */
	public List<HuoDong> list(Map<String, Object> map);
	
	/**
	 * ��̨����
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public void add(HuoDong huoDong);
	public void update(HuoDong huoDong);
	public void delete(Integer id);
	
	public HuoDong getOne(Map<String, Object> map);
	

}
