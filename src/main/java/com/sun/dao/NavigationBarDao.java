package com.sun.dao;

import java.util.List;

import com.sun.entity.NavigationBar;

public interface NavigationBarDao {

	/**
	 * ��ѯȫ����Ϣ
	 * @return
	 */
	public List<NavigationBar> finList();
	
	/**
	 * ��ҳ�Ƽ�Ʒ�ֺ����»
	 * @return
	 */
	public List<NavigationBar> hdatj();
}
