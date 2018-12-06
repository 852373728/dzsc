package com.sun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Jinxq;
import com.sun.entity.Spk;
import com.sun.entity.SpkCondition;

public interface JinxqDao {
	
	public List<Jinxq> list(Map<String, Object> map);
	
	public List<Jinxq> unLongin(Map<String, Object> map);
	
	public Long total(Map<String, Object> map);
	
	public List<SpkCondition> findSplbTwo(Map<String, Object> map);
	
	public List<SpkCondition> findJx(Map<String, Object> map);
	
	public Long findKc(Map<String, Object> map);

	public Jinxq getOne(Map<String, Object> map);
	
	public void editZtsl(Map<String, Object> map);
	
	public Spk unLoginInOne(@Param("id")String id);
	
	public Spk LoginInOne(@Param("id")String id);
	
}
