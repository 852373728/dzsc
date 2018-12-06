package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.SpddMx;

public interface SpddMxDao {
	
	/**
	 * 添加商品明细订单
	 * @param spddMx
	 */
	public void add(SpddMx spddMx);
	
	/**
	 * 根据各种条件查询订单从表list
	 * @param map
	 * @return
	 */
	public List<SpddMx> list(Map<String, Object> map);

}
