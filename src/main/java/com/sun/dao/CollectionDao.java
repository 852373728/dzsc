package com.sun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Collect;

public interface CollectionDao {

	public void add(Collect collect);
	
	public List<Collect> findByUserName(@Param("userName")String userName);
	
	public void delete(Integer id);
	
	public Long exit(Map<String, Object> map);
}
