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
	 * �ͻ�ע��
	 * @param kh
	 */
	public void add(Kh kh) {
		khDao.add(kh);
	}
	
	/**
	 * ��ѯ�ͻ�
	 * @param map
	 * @return
	 */
	public Kh find(Kh kh) {
		return khDao.find(kh); 
	}
	
	/**
	 * ���û���¼��ÿ���й���˽�����󣬶�Ҫ���ø÷��������ж��û����������Ƿ���ȷ��ֻ�ܱ�֤�û��������룬���ñ�֤���û�zt�Ƿ�Ϊ2
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
	 * ���û���¼��ÿ���й���˽�����󣬶�Ҫ���ø÷��������ж��û����������Ƿ���ȷ,�����ж��û�zt�Ƿ�Ϊ2
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
	 * �޸�����
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
