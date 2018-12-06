package com.sun.service;

import java.util.List;
import java.util.Map;


import com.sun.entity.Jinxq;
import com.sun.entity.Kh;
import com.sun.entity.ShopCar;

public interface ShopCarService {

	/**
	 * 添加购物车商品
	 * @param shopCar
	 */
	public void add(ShopCar shopCar);
	
	/**
	 * 购物车查询，不包含商品
	 * @param map
	 * @return
	 */
	public List<ShopCar> list(Map<String, Object> map);
	
	/**
	 * 购物车条数
	 * @param map
	 * @return
	 */
	public Long Count(Map<String, Object> map);
	
	/**
	 * 修改购物车
	 * @param shopCar
	 */
	public void update(ShopCar shopCar);
	
	/**
	 * 购物车查询，包含商品
	 * @param map
	 * @return
	 */
	public List<ShopCar> list(Map<String, Object> map,boolean hasSpk,Kh kh);
	
	/**
	 * 通过id删除
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 往购物车添加促销商品
	 * @param shopCar
	 */
	public void addCx(ShopCar shopCar);
	
	/**
	 * 判断购物车是否已有该促销商品，只针对促销商品
	 * @param shopCar
	 * @return
	 */
	public Long judgeExit(ShopCar shopCar);
	
	/**
	 * 购物车已有该促销商品，在此基础上加数量
	 * @param shopCar
	 */
	public void editExit(ShopCar shopCar);
	
	/**
	 * 购物车促销商品查询
	 * @param username
	 * @return
	 */
	public List<Jinxq> cxList(String username);
}
