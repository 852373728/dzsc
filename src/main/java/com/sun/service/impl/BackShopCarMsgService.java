package com.sun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackShopCarMsgDao;
import com.sun.entity.ShopCarMsg;

@Service
public class BackShopCarMsgService {

	@Resource
	private BackShopCarMsgDao backShopCarMsgDao;
	
	public boolean update(ShopCarMsg shopCarMsg){
		backShopCarMsgDao.update(shopCarMsg);
		return true;
	}
	
	public List<ShopCarMsg> list(){
		return backShopCarMsgDao.list();
	}
	
	public ShopCarMsg getOne(Integer id) {
		return backShopCarMsgDao.getOne(id);
	}
	
}
