package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.ThreeBar;

public interface ThreeBarService {

	/**
	 * �ר���ֲ�ͼƬ����ʾ
	 * @return
	 */
	public List<ThreeBar> findCarousel();
	
	/**
	 * �ר��ҳ�桰ר������Ŀ
	 * @return
	 */
	public List<ThreeBar> zthd();
	
	/**
	 * �����������ķ�ҳ��ѯ
	 * @param map
	 * @return
	 */
	public List<ThreeBar> fenye(Map<String, Object> map);
	
	/**
	 * ����������������
	 * @return
	 */
	public Long total(Map<String, Object> map);
}
