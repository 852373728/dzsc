package com.sun.service;

import com.sun.entity.Admin;

public interface BackAdminservice {

	/**
	 * ��̨��¼
	 * @param admin
	 * @return
	 */
	public Admin login(String userName);
}
