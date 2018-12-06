package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.TwoBar;

public interface BackTwoBarService {

	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<TwoBar> list(Map<String, Object> map);
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public boolean add(TwoBar twoBar);
	
	public boolean update(TwoBar twoBar);
	
	public boolean delete(String ids);
	
	/**
	 * 根据barid查询list
	 * @param barid
	 * @return
	 */
	public List<TwoBar> findByBarId(Integer barid);
}
