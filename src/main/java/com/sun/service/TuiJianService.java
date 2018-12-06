package com.sun.service;

import java.util.List;

import com.sun.entity.TuiJian;

public interface TuiJianService {

	/**
	 * 根据showCarousel=1字段查询，推荐品种页面的轮播
	 * @return
	 */
	public List<TuiJian> carousel();
}
