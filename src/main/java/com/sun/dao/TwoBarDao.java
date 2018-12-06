package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.TwoBar;

public interface TwoBarDao {

	/**
	 * ���� NavigationBarId��ѯ����
	 * @param map
	 * @return
	 */
	public List<TwoBar> findByBarId(Map<String, Object> map);
	
	/**
	 * ��ѯ����barid=5�Ļ��������
	 * @return
	 */
	public List<TwoBar> findByHuodong();
}
