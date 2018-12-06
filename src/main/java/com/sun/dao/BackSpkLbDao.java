package com.sun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.SpkLb;

public interface BackSpkLbDao {

	
	public SpkLb getOnebyLbdm(@Param("lbdm")String lbdm);
	
	
	/**
	 * 后台商品分类的查询，树形表格
	 * @param lbparent
	 * @return
	 */
	public List<SpkLb> findByLbParent(@Param("lbparent")String lbparent);
	
	public void update(Map<String, Object> map);
	
	/**
	 * combobox
	 * @param map
	 * @return
	 */
	public List<SpkLb> list(Map<String, Object> map);
	
}
