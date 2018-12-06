package com.sun.service;

import java.util.List;
import java.util.Map;


import com.sun.entity.Kh;
import com.sun.entity.Spk;

public interface SpkService {


	/**
	 * 用户未登录时，通过spkID获得实体，某些字段不予展示
	 * @param id
	 * @return
	 */
	public Spk getOne(Integer id);
	
	/**
	 * 用户已登录，通过spkID获得实体，展示的字段多些，其它没区别
	 * @param id
	 * @return
	 */
	public Spk getOneUser(Integer id,Kh kh);
	
	/**
	 * 全部商品销量排行查询
	 * @return
	 */
	public List<Spk> sale();
	
	/**
	 * 全部商品点击排行查询
	 * @return
	 */
	public List<Spk> click();
	
	/**
	 * 可供页面的商品查询
	 * @param map
	 * @return
	 */
	public List<Spk> findSpkList(Map<String, Object> map,boolean loggedIn,Kh kh);
	
	/**
	 * 可供页面的商品总条数查询
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	/**
	 * 可供页面展示的商品所属的二级分类列表
	 * @param map
	 * @return
	 */
	public List<Spk> findSplbTwo(Map<String, Object> map);
	
	/**
	 * 可供页面展示的商品所属的一级分类列表
	 * @param map
	 * @return
	 */
	public List<Spk> findSplbOne(Map<String, Object> map);
	
	/**
	 * 可供页面展示的商品所属的生产厂家，固定查询15个厂家，排序规则参照sccj表
	 * @param map
	 * @return
	 */
	public List<Spk> findSccj(Map<String, Object> map);
	
	/**
	 * 可供页面展示的商品所属剂型，去掉了空的
	 * @param map
	 * @return
	 */
	public List<Spk> findJx(Map<String, Object> map);
	
	/**
	 * 可供页面展示的商品所属处方类型，去掉了空的
	 * @param map
	 * @return
	 */
	public List<Spk> findXz(Map<String, Object> map);
	
	/**
	 * 可供页面展示的商品所属医保类型，去掉了空的
	 * @param map
	 * @return
	 */
	public List<Spk> findyl(Map<String, Object> map);
	
	/**
	 * 推荐品种更多页面的“推荐类型”条件
	 * @param map
	 * @return
	 */
	public List<Spk> findTwoBar(Map<String, Object> map);
	
	/**
	 * 热销新品
	 * @return
	 */
	public List<Spk> hotNew();
	
	/**
	 * 商品详情页面，右边的热销，新品查询
	 * @param map
	 * @return
	 */
	public List<Spk> goodRight(Map<String, Object> map,boolean loggedIn,Kh kh);
	
	/**
	 * 根据厂家名称查找商品
	 * @param SCCJ1
	 * @return
	 */
	public List<Spk> findBySCCJ1(Map<String, Object> map,boolean loggedIn,Kh kh);
	
	/**
	 * 点击排行和销量排行的修改
	 * @param map
	 */
	public void editph(Map<String, Object> map);
	
	public Spk getOneUserBymap(Map<String, Object> map);
	
	/**
	 * 商品的可用数量，用户购买进行数量验证，数量不足不能购买
	 * @param spdm
	 * @return
	 */
	public String kysl(String spdmStrs,String sls,Kh kh,String spphs);
	
	/**
	 * 首页新品上市小模块的查询
	 * @return
	 */
	public List<Spk> shouyexpss();
	
}
