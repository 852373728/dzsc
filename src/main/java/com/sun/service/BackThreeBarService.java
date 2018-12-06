package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.ThreeBar;

public interface BackThreeBarService {

	public List<ThreeBar> list(Map<String, Object> map);
	
	public Long total(Map<String, Object> map);
	
	public boolean add(ThreeBar threeBar);
	
	public boolean update(ThreeBar threeBar);
	
	public boolean delete(String ids);
	
	/**
	 * 根据导航条二级分类查询
	 * @param twoBarId
	 * @return
	 */
	public List<ThreeBar> listByTwoBar(Integer twoBarId);
}
