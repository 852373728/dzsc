package com.sun.service.impl;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sun.dao.KhDao;
import com.sun.entity.Kh;
import com.sun.service.KhService;
import com.sun.util.StringUtil;

@Service("khService")
public class KhServiceImpl implements KhService{

	@Resource
	private KhDao khDao;
	
	/**
	 * 客户注册
	 * @param kh
	 */
	public void add(Kh kh) {
		khDao.add(kh);
	}
	
	/**
	 * 查询客户
	 * @param map
	 * @return
	 */
	public Kh find(Kh kh) {
		return khDao.find(kh); 
	}
	
	/**
	 * 当用户登录后，每次有关隐私的请求，都要调用该方法，已判定用户名，密码是否正确，只能保证用户名和密码，不用保证该用户zt是否为2
	 * @param kh
	 * @return
	 */
	public Kh noHasKh(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			String email="";
			String password="";
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("email")) {
					email=cookie.getValue();
				}else if(cookie.getName().equals("password")) {
					password=cookie.getValue();
				}
			}
			Kh kh=new Kh(email, password);
			if(kh!=null && StringUtil.isNotEmpty(kh.getEmail()) && StringUtil.isNotEmpty(kh.getPassword())) {
				Kh kh2 = khDao.find(kh);
				if(kh2!=null) {
					return kh2;
				}else {
					return null;
				}
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	/**
	 * 当用户登录后，每次有关隐私的请求，都要调用该方法，以判定用户名，密码是否正确,并且判定用户zt是否为2
	 * @param kh
	 * @return
	 */
	public Kh noHasKh_Zt2(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			String email="";
			String password="";
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("email")) {
					email=cookie.getValue();
				}else if(cookie.getName().equals("password")) {
					password=cookie.getValue();
				}
			}
			Kh kh=new Kh(email, password);
			if(kh!=null && StringUtil.isNotEmpty(kh.getEmail()) && StringUtil.isNotEmpty(kh.getPassword())) {
				Kh kh2 = khDao.buyPermissions(kh);
				if(kh2!=null) {
					return kh2;
				}else {
					return null;
				}
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	/**
	 * 修改密码
	 * @param map
	 */
	public boolean editPwd(Map<String, Object> map) {
		try {
			khDao.editPwd(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
