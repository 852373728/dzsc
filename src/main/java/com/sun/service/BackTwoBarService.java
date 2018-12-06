package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.TwoBar;

public interface BackTwoBarService {

	/**
	 * ��̨list
	 * @param map
	 * @return
	 */
	public List<TwoBar> list(Map<String, Object> map);
	
	/**
	 * ��̨����
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public boolean add(TwoBar twoBar);
	
	public boolean update(TwoBar twoBar);
	
	public boolean delete(String ids);
	
	/**
	 * ����barid��ѯlist
	 * @param barid
	 * @return
	 */
	public List<TwoBar> findByBarId(Integer barid);
}
