package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.TwoBar;

public interface TwoBarDao {

	/**
	 * 根据 NavigationBarId查询集合
	 * @param map
	 * @return
	 */
	public List<TwoBar> findByBarId(Map<String, Object> map);
	
	/**
	 * 查询所有barid=5的活动二级分类
	 * @return
	 */
	public List<TwoBar> findByHuodong();
}
