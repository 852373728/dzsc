package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.MainShow;

public interface MainShowDao {

	/**
	 * �����ֶ�sywzdm����ѯ��ʾλ�õ���Ʒ
	 * @return
	 */
	public List<MainShow> findListBySywzdm(Map<String, Object> map);
}
