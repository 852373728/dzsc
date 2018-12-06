package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.MainShow;

public interface BackMainShowService {

	/**
	 * ��̨list
	 * @param map
	 * @return
	 */
	public List<MainShow> list(Map<String, Object> map);
	
	/**
	 * ��̨����
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public boolean add(MainShow mainShow);
	public boolean update(MainShow mainShow);
	public boolean delete(String ids);
}
