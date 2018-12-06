package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackSpkDao;
import com.sun.entity.Spk;
import com.sun.service.BackSpkService;

@Service("backSpkService")
public class BackSpkServiceImpl implements BackSpkService{
	
	@Resource
	private BackSpkDao backSpkDao;
	
	public List<Spk> list(Map<String, Object> map){
		return backSpkDao.list(map);
	}
	
	public Long total(Map<String, Object> map) {
		return backSpkDao.total(map);
	}
	
	/**
	 * 没有限制条件，分开写清晰点
	 * @param map
	 * @return
	 */
	public List<Spk> listAll(Map<String, Object> map){
		return backSpkDao.listAll(map);
	}
	
	public Long totalAll(Map<String, Object> map) {
		return backSpkDao.totalAll(map);
	}

}
