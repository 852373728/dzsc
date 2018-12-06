package com.sun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.ThreeBar;

public interface BackThreeBarDao {
	
	public List<ThreeBar> list(Map<String, Object> map);
	
	public Long total(Map<String, Object> map);
	
	public void add(ThreeBar threeBar);
	
	public void update(ThreeBar threeBar);
	
	public void delete(Integer id);
	
	public ThreeBar getOne(Integer id);
	
	/**
	 * ���ݵ��������������ѯ
	 * @param twoBarId
	 * @return
	 */
	public List<ThreeBar> listByTwoBar(@Param("twoBarId")Integer twoBarId);

}
