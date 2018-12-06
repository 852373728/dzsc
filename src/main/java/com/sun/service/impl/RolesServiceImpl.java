package com.sun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.RolesDao;
import com.sun.entity.Roles;
import com.sun.service.RolesService;

@Service("rolesService")
public class RolesServiceImpl implements RolesService{

	@Resource
	private RolesDao rolesDao;
	
	public List<Roles> list() {
		return rolesDao.list();
	}

}
