package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.Sccj;

public interface BackSccjDao {
	
	/**
	 * ��̨list
	 * @param map
	 * @return
	 */
	public List<Sccj> list(Map<String, Object> map);
	
	/**
	 * ��̨����
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public void update(Sccj sccj);

}
