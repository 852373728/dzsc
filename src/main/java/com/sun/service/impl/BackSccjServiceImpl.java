package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackSccjDao;
import com.sun.dao.BackSpkLbDao;
import com.sun.entity.Sccj;
import com.sun.service.BackSccjService;

@Service("backSccjService")
public class BackSccjServiceImpl implements BackSccjService{

	@Resource
	private BackSccjDao backSccjDao;
	@Resource
	private BackSpkLbDao backSpkLbDao;
	
	
	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<Sccj> list(Map<String, Object> map){
		List<Sccj> sccjList = backSccjDao.list(map);
		for (Sccj sccj : sccjList) {
			sccj.setSpkLb(backSpkLbDao.getOnebyLbdm(sccj.getSplbDm()));
		}
		return sccjList;
	}
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return backSccjDao.total(map);
	}
	
	public boolean update(Sccj sccj) {
		try {
			backSccjDao.update(sccj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
