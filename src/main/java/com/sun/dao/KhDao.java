package com.sun.dao;


import java.util.Map;

import com.sun.entity.Kh;

public interface KhDao {

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
	 * ���й���Ȩ�޵��û�
	 * @param kh
	 * @return
	 */
	public Kh buyPermissions(Kh kh);
	
	/**
	 * �޸�����
	 * @param map
	 */
	public void editPwd(Map<String, Object> map);
	
}
