package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.MainShow;

public interface MainShowDao {

	/**
	 * 根据字段sywzdm来查询显示位置的商品
	 * @return
	 */
	public List<MainShow> findListBySywzdm(Map<String, Object> map);
}
