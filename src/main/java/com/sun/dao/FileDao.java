package com.sun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.T_File;

public interface FileDao {

	public void add(T_File file);
	
	public List<T_File> list(Map<String, Object> map);
	
	public Long total(Map<String, Object> map);
	
	public void delete(@Param("id")Integer id);
	
}
