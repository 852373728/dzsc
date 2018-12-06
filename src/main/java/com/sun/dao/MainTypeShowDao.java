package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.MainTypeShow;

public interface MainTypeShowDao {

	/**
	 * 用于首页药品等栏目下商品库信息查询 SpkLbServiceImpl
	 * @param map
	 * @return
	 */
	public List<MainTypeShow> findhpBylbDm(Map<String, Object> map);
}
