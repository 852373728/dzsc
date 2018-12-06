package com.sun.service;

import java.util.List;
import java.util.Map;


import com.sun.entity.SpkLb;

public interface BackSpkLbService {

	/**
	 * ��̨��Ʒ����Ĳ�ѯ�����α��
	 * @param lbparent
	 * @return
	 */
	public List<SpkLb> findByLbParent(String lbparent);
	
	public boolean update(String data);
	
	/**
	 * combobox
	 * @param map
	 * @return
	 */
	public List<SpkLb> list(Map<String, Object> map);
	
	public SpkLb getOnebyLbdm(String lbdm);
}
