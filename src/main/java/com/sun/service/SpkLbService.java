package com.sun.service;

import java.util.List;

import com.sun.entity.Kh;
import com.sun.entity.SpkLb;

public interface SpkLbService {

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
	public List<SpkLb> findLevel(boolean loggedIn,Kh kh);
}
