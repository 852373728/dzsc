package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.Kh;
import com.sun.entity.Sccj;

public interface SccjService {

	/**
	 * �Ƽ�ҳ��ĳ�����ʾ
	 * @return
	 */
	public List<Sccj> tuiJian();
	
	/**
	 * Ʒ��ר�������12��������ʾ�������ֶ�pinpaiShow=1��ѯ
	 * @return
	 */
	public List<Sccj> pinpaiShow();
	
	/**
	 * Ʒ��ר�����ҷ�ҳ��ѯ
	 * @param map
	 * @return
	 */
	public List<Sccj> fenye(Map<String, Object> map,boolean loggedIn,Kh kh);
	
	/**
	 * Ʒ��ר����������������ʾ
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	/**
	 * ���ݳ������ƻ�øó���ʵ��
	 * @param cjmc
	 * @return
	 */
	public Sccj getSccj(String cjmc,Map<String, Object> map,boolean loggedIn,Kh kh);
}
