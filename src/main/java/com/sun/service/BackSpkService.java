package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.Spk;

public interface BackSpkService {

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
