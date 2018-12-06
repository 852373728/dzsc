package com.sun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.RolesPermissionsDao;
import com.sun.entity.Roles_permissions;
import com.sun.service.RolesPermissionsService;
import com.sun.util.StringUtil;

@Service("rolesPermissionsService")
public class RolesPermissionsServiceImpl implements RolesPermissionsService{

	@Resource
	private RolesPermissionsDao rolesPermissionsDao;
	
	public List<Integer> byRolesName(String rolesName) {
		return rolesPermissionsDao.byRolesName(rolesName);
	}
	
	@Transactional
	public boolean add(String roleName,String str) {
		rolesPermissionsDao.delete(roleName);
		if(StringUtil.isNotEmpty(str)) {
			String[] split = str.split(",");
			for (String string : split) {
				rolesPermissionsDao.add(new Roles_permissions(roleName, Integer.parseInt(string)));
			}
		}
		return true;
	}

}
