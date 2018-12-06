package com.sun.dao;

import java.util.List;
import java.util.Map;


import com.sun.entity.HistoryGoods;

public interface HistoryGoodsDao {

	public void add(HistoryGoods historyGoods);
	
	public void update(HistoryGoods historyGoods);
	
	public List<HistoryGoods> findByUserName(Map<String, Object> map);
	
	public Long exit(Map<String, Object> map);
}
