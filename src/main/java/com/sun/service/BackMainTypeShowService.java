package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.MainTypeShow;

public interface BackMainTypeShowService {

	/**
	 * ��̨list
	 * @param map
	 * @return
	 */
	public List<MainTypeShow> list(Map<String, Object> map);
	
	/**
	 * ��̨����
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public boolean add(MainTypeShow mainTypeShow);
	public boolean update(MainTypeShow mainTypeShow);
	public boolean delete(String ids);
}
