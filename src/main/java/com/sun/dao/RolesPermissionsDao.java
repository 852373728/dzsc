package com.sun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Roles_permissions;

public interface RolesPermissionsDao {

	public List<Integer> byRolesName(@Param("rolesName")String rolesName);
	
	public void delete(@Param("rolesname")String rolesname );
	
	public void add(Roles_permissions rolePermission);
	
}
