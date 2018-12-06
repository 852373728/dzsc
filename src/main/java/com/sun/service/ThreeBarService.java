package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.ThreeBar;

public interface ThreeBarService {

	/**
	 * 活动专区轮播图片的显示
	 * @return
	 */
	public List<ThreeBar> findCarousel();
	
	/**
	 * 活动专区页面“专题活动”栏目
	 * @return
	 */
	public List<ThreeBar> zthd();
	
	/**
	 * 导航条三级的分页查询
	 * @param map
	 * @return
	 */
	public List<ThreeBar> fenye(Map<String, Object> map);
	
	/**
	 * 导航条三级的总数
	 * @return
	 */
	public Long total(Map<String, Object> map);
}
