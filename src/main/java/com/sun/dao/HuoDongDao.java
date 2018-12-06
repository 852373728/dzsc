package com.sun.dao;

import java.util.List;


import com.sun.entity.HuoDong;

public interface HuoDongDao {

	/**
	 * 根据homePageHuoDongCarousel=1字段查询,该查询为首页最新活动栏目下左边的轮播图片查询
	 * @return
	 */
	public List<HuoDong> findByhpCarosel();
	
	/*
	 * 根据导航条两个分类查询活动的商品
	 */
	public List<HuoDong> findByTwoBarId(Integer twobarid);
	
	/**
	 * 活动页面的活动商品查询
	 * @param threebarid
	 * @return
	 */
	public List<HuoDong> hdyList(Integer twobarid);
	
	/**
	 * 根据商品库id查询和一系列的条件查询该商品是否正在参加活动
	 * @param spkid
	 * @return
	 */
	public HuoDong getBySpkId(Integer spkid);
 }
