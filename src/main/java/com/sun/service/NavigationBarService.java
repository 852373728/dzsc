package com.sun.service;

import java.util.List;

import com.sun.entity.Kh;
import com.sun.entity.NavigationBar;

public interface NavigationBarService {

	/**
	 * 查询全部信息
	 * @return
	 */
	public List<NavigationBar> finList();
	
	/**
	 * 首页推荐品种和最新活动,参数用来确定用户是否已登录，未登录传false，已登录传true
	 * @return
	 */
	public List<NavigationBar> hdatj(boolean loggedIn,Kh kh);
}
