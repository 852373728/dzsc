package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.Kh;
import com.sun.entity.Spdd;

public interface SpddService {

	/**
	 * ��Ӷ���
	 * @param spdd
	 */
	public boolean add(String spdmStrs,String sls,Kh kh,String spphs);
	
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
