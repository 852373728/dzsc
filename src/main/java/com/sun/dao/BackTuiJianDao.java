package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.TuiJian;

public interface BackTuiJianDao {

	/**
	 * ��̨list
	 * @param map
	 * @return
	 */
	public List<TuiJian> list(Map<String, Object> map);
	
	/**
	 * ��̨����
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	/*public void add(TuiJian tuiJian);*/
	
	public void update(TuiJian tuiJian);
	
	public void delete(Integer id);
	
 }
