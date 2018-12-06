package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.TwoBar;

public interface BackTwoBarDao {
	
	public TwoBar getOne(Integer id);
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
	
	public void add(TwoBar twoBar);
	
	public void update(TwoBar twoBar);
	
	public void delete(Integer id);
	
	/**
	 * 根据barid查询list
	 * @param barid
	 * @return
	 */
	public List<TwoBar> findByBarId(Integer barid);

}
