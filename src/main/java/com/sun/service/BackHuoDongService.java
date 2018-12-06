package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.HuoDong;

public interface BackHuoDongService {

	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<HuoDong> list(Map<String, Object> map);
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public boolean add(HuoDong huoDong);
	public boolean update(HuoDong huoDong);
	public boolean delete(String ids);
	
	public HuoDong getOne(Map<String, Object> map);
}
