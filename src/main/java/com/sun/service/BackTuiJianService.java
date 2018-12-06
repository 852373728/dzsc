package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.TuiJian;

public interface BackTuiJianService {

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
	
	/*public boolean add(TuiJian tuiJian);*/
	
	public boolean update(TuiJian tuiJian);
	
	public boolean delete(String ids);
}
