package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.MainTypeShow;

public interface MainTypeShowDao {

	/**
	 * ������ҳҩƷ����Ŀ����Ʒ����Ϣ��ѯ SpkLbServiceImpl
	 * @param map
	 * @return
	 */
	public List<MainTypeShow> findhpBylbDm(Map<String, Object> map);
}
