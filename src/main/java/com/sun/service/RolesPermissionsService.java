package com.sun.service;

import java.util.List;

public interface RolesPermissionsService {

	public List<Integer> byRolesName(String rolesName);
	
	public boolean add(String roleName,String str);
}
