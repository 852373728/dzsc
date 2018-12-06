package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.TuiJian;

public interface BackTuiJianDao {

	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<TuiJian> list(Map<String, Object> map);
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	/*public void add(TuiJian tuiJian);*/
	
	public void update(TuiJian tuiJian);
	
	public void delete(Integer id);
	
 }
