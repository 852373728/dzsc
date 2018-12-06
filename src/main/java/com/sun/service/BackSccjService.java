package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.Sccj;

public interface BackSccjService {

	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<Sccj> list(Map<String, Object> map);
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public boolean update(Sccj sccj);
}
