package com.sun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.UserCenterDao;
import com.sun.entity.UserCenter;
import com.sun.service.UserCenterService;

@Service("userCenterService")
public class UserCenterServiceImpl implements UserCenterService{

	@Resource
	private UserCenterDao userCenterDao;
	
	public List<UserCenter> listByParentId(List<Integer> list) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("parentid", -1);
		map.put("roleList", list);
		List<UserCenter> userCenterList = userCenterDao.listByParentId(map);
		for (UserCenter userCenter : userCenterList) {
			map.put("parentid",userCenter.getId());
			map.put("roleList", list);
			userCenter.setUserCenterList(userCenterDao.listByParentId(map));
		}
		return userCenterList;
	}
	
	/**
	 * ·µ»ΨΚµΜε
	 * @param map
	 * @return
	 */
	public UserCenter getOne(Map<String, Object> map) {
		UserCenter userCenter = userCenterDao.getOne(map);
		map.clear();
		map.put("id", userCenter.getParentId());
		userCenter.setUserCenter(userCenterDao.getOne(map));
		return userCenter;
	}

	public List<String> listByID(List<Integer> list) {
		return userCenterDao.listByID(list);
	}
}
