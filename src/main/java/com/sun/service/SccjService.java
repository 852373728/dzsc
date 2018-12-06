package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.Kh;
import com.sun.entity.Sccj;

public interface SccjService {

	/**
	 * 推荐页面的厂家显示
	 * @return
	 */
	public List<Sccj> tuiJian();
	
	/**
	 * 品牌专区上面的12个厂家显示，根据字段pinpaiShow=1查询
	 * @return
	 */
	public List<Sccj> pinpaiShow();
	
	/**
	 * 品牌专区厂家分页查询
	 * @param map
	 * @return
	 */
	public List<Sccj> fenye(Map<String, Object> map,boolean loggedIn,Kh kh);
	
	/**
	 * 品牌专区厂家总条数的显示
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	/**
	 * 根据厂家名称获得该厂家实体
	 * @param cjmc
	 * @return
	 */
	public Sccj getSccj(String cjmc,Map<String, Object> map,boolean loggedIn,Kh kh);
}
