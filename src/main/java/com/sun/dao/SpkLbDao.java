package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.SpkLb;

public interface SpkLbDao {

	/**
	 * �����ֶ�lbparent����ѯ���ϣ��ݹ��ѯ
	 * @param lbparent
	 * @return
	 */
	public List<SpkLb> findByLbParent(String lbparent);
	
	/**
	 * ������ҳһ���������ѯ
	 * @return
	 */
	public List<SpkLb> findLevel(Map<String, Object> map);
}
