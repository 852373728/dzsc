package com.sun.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sun.entity.Kh;

public interface KhService {

	/**
	 * 客户注册
	 * @param kh
	 */
	public void add(Kh kh);
	
	/**
	 * 查询客户
	 * @param map
	 * @return
	 */
	public Kh find(Kh kh);
	
	/**
	 * 当用户登录后，每次有关隐私的请求，都要调用该方法，已判定用户名，密码是否正确
	 * @param kh
	 * @return
	 */
	public  Kh noHasKh(HttpServletRequest request);
	
	/**
	 * 当用户登录后，每次有关隐私的请求，都要调用该方法，以判定用户名，密码是否正确,并且判定用户zt是否为2
	 * @param kh
	 * @return
	 */
	public  Kh noHasKh_Zt2(HttpServletRequest request);
	
	/**
	 * 修改密码
	 * @param map
	 */
	public boolean editPwd(Map<String, Object> map);
}
