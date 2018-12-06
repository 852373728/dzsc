package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.Spdd;

public interface SpddDao {

	/**
	 * 添加订单
	 * @param spdd
	 */
	public void add(Spdd spdd);
	
	/**
	 * 查询当天最大的订单编号
	 * @return
	 */
	public String maxddh();
	
	/**
	 * 商品订单主表的查询，根据各种条件
	 * @param map
	 * @return
	 */
	public List<Spdd> list(Map<String, Object> map);
	
	/**
	 * 根据条件查询一个spdd
	 * @param map
	 * @return
	 */
	public Spdd getOne(Map<String, Object> map);
}
