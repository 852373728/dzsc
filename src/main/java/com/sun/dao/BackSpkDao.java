package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.Spk;

public interface BackSpkDao {

	/**
	 * 获得一个实体
	 * @param map
	 * @return
	 */
	public Spk getOne(Map<String, Object> map);
	
	/**
	 * 有限制条件
	 * @param map
	 * @return
	 */
	public List<Spk> list(Map<String, Object> map);
	
	public Long total(Map<String, Object> map);
	
	/**
	 * 没有限制条件，分开写清晰点
	 * @param map
	 * @return
	 */
	public List<Spk> listAll(Map<String, Object> map);
	
	public Long totalAll(Map<String, Object> map);
	
}
