package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sun.dao.JinxqDao;
import com.sun.entity.Jinxq;
import com.sun.entity.Kh;
import com.sun.entity.Spk;
import com.sun.entity.SpkCondition;
import com.sun.service.KhService;

@Service
public class JinxqService {

	@Resource
	private JinxqDao jinxqDao;
	@Resource
	private KhService khService;
	
	public List<Jinxq> list(Map<String, Object> map,HttpServletRequest request){
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			return jinxqDao.unLongin(map);
		}else {
			return jinxqDao.list(map);
		}
	}
	
	
	
	public Long total(Map<String, Object> map) {
		return jinxqDao.total(map);
	}
	
	public List<SpkCondition> findSplbTwo(Map<String, Object> map){
		return jinxqDao.findSplbTwo(map);
	}
	
	public List<SpkCondition> findJx(Map<String, Object> map){
		return jinxqDao.findJx(map);
	}
	
	public Long findKc(Map<String, Object> map) {
		return jinxqDao.findKc(map);
	}
	
	public Spk getOne(String id,HttpServletRequest request) {
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			return jinxqDao.unLoginInOne(id);
		}else {
			return jinxqDao.LoginInOne(id);
		}
	}
	
	
}
