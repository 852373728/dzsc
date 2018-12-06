package com.sun.service;

import java.util.List;
import java.util.Map;


import com.sun.entity.Kh;

public interface BackKhService {

	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<Kh> list(Map<String, Object> map);
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	public boolean update(Kh kh);
	
	public boolean delete(String emails);
}
