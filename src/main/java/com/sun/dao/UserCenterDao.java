package com.sun.dao;

import java.util.List;
import java.util.Map;

import com.sun.entity.UserCenter;

public interface UserCenterDao {

	/**
	 * ���ݸ�Id��ѯ��tree��,����list
	 * @param map
	 * @return
	 */
	public List<UserCenter> listByParentId(Map<String, Object> map);
	
	/**
	 * ����ʵ��
	 * @param map
	 * @return
	 */
	public UserCenter getOne(Map<String, Object> map);
	
	/**
	 * ����id���ϲ�ѯlist
	 * @param list
	 * @return
	 */
	public List<String> listByID(List<Integer> list);
	
}
