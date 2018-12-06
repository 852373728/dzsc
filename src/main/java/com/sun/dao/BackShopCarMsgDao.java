package com.sun.dao;

import java.util.List;

import com.sun.entity.ShopCarMsg;

public interface BackShopCarMsgDao {

	public void update(ShopCarMsg shopCarMsg);
	
	public List<ShopCarMsg> list();
	
	public ShopCarMsg getOne(Integer id);
}
