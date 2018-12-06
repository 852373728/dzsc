package com.sun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.TuiJian;

public interface TuiJianDao {

	/**
	 * 根据homePageTuijianCarousel=1字段查询,该查询为首页推荐品种栏目下左边的轮播图片查询
	 * @return
	 */
	public List<TuiJian> findByhpCarosel();
	
	/**
	 * 根据导航条二级分类查询商品
	 * @return
	 */
	public List<TuiJian> findBytwoBarName(@Param("twobarname")String twobarname);
	
	/**
	 * 根据showCarousel=1字段查询，推荐品种页面的轮播
	 * @return
	 */
	public List<TuiJian> carousel();
	
	/**
	 * 推荐页面下各栏目下最左边第一张图片查询
	 * @param twobarid
	 * @return
	 */
	public TuiJian findByshow2(@Param("twobarname")String twobarname);
 }
