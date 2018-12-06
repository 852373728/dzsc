package com.sun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackAdminDao;
import com.sun.entity.Admin;
import com.sun.service.BackAdminservice;

@Service("backAdminservice")
public class BackAdminServiceImpl implements BackAdminservice{

	@Resource
	private BackAdminDao backAdminDao;
	
	/**
	 * ºóÌ¨µÇÂ¼
	 * @param admin
	 * @return
	 */
	public Admin login(String userName) {
		return backAdminDao.login(userName);
	}
}
