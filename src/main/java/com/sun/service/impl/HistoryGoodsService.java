package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.HistoryGoodsDao;
import com.sun.entity.HistoryGoods;

@Service
public class HistoryGoodsService{

	@Resource
	private HistoryGoodsDao historyGoodsDao;
	
	public List<HistoryGoods> findByUserName(Map<String, Object> map) {
		List<HistoryGoods> hgList = historyGoodsDao.findByUserName(map);
		return hgList;
	}

}
