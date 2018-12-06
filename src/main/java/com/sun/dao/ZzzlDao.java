package com.sun.dao;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Zzzl;

public interface ZzzlDao {

	public Zzzl judge(@Param("khdm")String khdm);
	
}
