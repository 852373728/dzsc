package com.sun.service;

import java.util.List;

import com.sun.entity.Kh;
import com.sun.entity.NavigationBar;

public interface NavigationBarService {

	/**
	 * ��ѯȫ����Ϣ
	 * @return
	 */
	public List<NavigationBar> finList();
	
	/**
	 * ��ҳ�Ƽ�Ʒ�ֺ����»,��������ȷ���û��Ƿ��ѵ�¼��δ��¼��false���ѵ�¼��true
	 * @return
	 */
	public List<NavigationBar> hdatj(boolean loggedIn,Kh kh);
}
