package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.UserCenter;

public interface UserCenterService {

	/**
	 * ���ݸ�Id��ѯ��tree��
	 * @param map
	 * @return
	 */
	public List<UserCenter> listByParentId(List<Integer> list);
	
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
