package com.sun.service;

import java.util.List;

import com.sun.entity.Kh;
import com.sun.entity.TwoBar;

public interface TwoBarService {

	/**
	 * �Ƽ�ҳ��Ķ������ѯ����Ʒ�Ƽ���
	 * @param map
	 * @return
	 */
	public List<TwoBar> findByBarId(boolean loggedIn,Kh kh);
	
	/**
	 * ��ѯ����barid=5�Ļ��������
	 * @return
	 */
	public List<TwoBar> findByHuodong(boolean loggedIn,Kh kh);
}
