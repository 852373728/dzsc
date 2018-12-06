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
	 * ���ݵ��������������ѯ
	 * @param twoBarId
	 * @return
	 */
	public List<ThreeBar> listByTwoBar(Integer twoBarId);
}
