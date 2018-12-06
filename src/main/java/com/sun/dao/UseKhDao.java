package com.sun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UseKhDao {
	
	
	public List<String> listK(@Param("condition")String condition);

}
