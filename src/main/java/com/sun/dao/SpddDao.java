package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.Spdd;

public interface SpddDao {

	/**
	 * ��Ӷ���
	 * @param spdd
	 */
	public void add(Spdd spdd);
	
	/**
	 * ��ѯ�������Ķ������
	 * @return
	 */
	public String maxddh();
	
	/**
	 * ��Ʒ��������Ĳ�ѯ�����ݸ�������
	 * @param map
	 * @return
	 */
	public List<Spdd> list(Map<String, Object> map);
	
	/**
	 * ����������ѯһ��spdd
	 * @param map
	 * @return
	 */
	public Spdd getOne(Map<String, Object> map);
}
