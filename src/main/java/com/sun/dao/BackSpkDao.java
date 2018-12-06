package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.Spk;

public interface BackSpkDao {

	/**
	 * ���һ��ʵ��
	 * @param map
	 * @return
	 */
	public Spk getOne(Map<String, Object> map);
	
	/**
	 * ����������
	 * @param map
	 * @return
	 */
	public List<Spk> list(Map<String, Object> map);
	
	public Long total(Map<String, Object> map);
	
	/**
	 * û�������������ֿ�д������
	 * @param map
	 * @return
	 */
	public List<Spk> listAll(Map<String, Object> map);
	
	public Long totalAll(Map<String, Object> map);
	
}
