package com.sun.service;

import java.util.List;

import com.sun.entity.Kh;
import com.sun.entity.TwoBar;

public interface TwoBarService {

	/**
	 * 推荐页面的二级类查询，新品推荐等
	 * @param map
	 * @return
	 */
	public List<TwoBar> findByBarId(boolean loggedIn,Kh kh);
	
	/**
	 * 查询所有barid=5的活动二级分类
	 * @return
	 */
	public List<TwoBar> findByHuodong(boolean loggedIn,Kh kh);
}
