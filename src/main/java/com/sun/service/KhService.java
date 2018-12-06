package com.sun.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sun.entity.Kh;

public interface KhService {

	/**
	 * �ͻ�ע��
	 * @param kh
	 */
	public void add(Kh kh);
	
	/**
	 * ��ѯ�ͻ�
	 * @param map
	 * @return
	 */
	public Kh find(Kh kh);
	
	/**
	 * ���û���¼��ÿ���й���˽�����󣬶�Ҫ���ø÷��������ж��û����������Ƿ���ȷ
	 * @param kh
	 * @return
	 */
	public  Kh noHasKh(HttpServletRequest request);
	
	/**
	 * ���û���¼��ÿ���й���˽�����󣬶�Ҫ���ø÷��������ж��û����������Ƿ���ȷ,�����ж��û�zt�Ƿ�Ϊ2
	 * @param kh
	 * @return
	 */
	public  Kh noHasKh_Zt2(HttpServletRequest request);
	
	/**
	 * �޸�����
	 * @param map
	 */
	public boolean editPwd(Map<String, Object> map);
}
