package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.SpddMx;

public interface SpddMxDao {
	
	/**
	 * �����Ʒ��ϸ����
	 * @param spddMx
	 */
	public void add(SpddMx spddMx);
	
	/**
	 * ���ݸ���������ѯ�����ӱ�list
	 * @param map
	 * @return
	 */
	public List<SpddMx> list(Map<String, Object> map);

}
