package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.MainShowDao;
import com.sun.dao.SpkDao;
import com.sun.entity.MainShow;
import com.sun.service.MainShowService;

@Service("mainShowService")
public class MainShowServiceImpl implements MainShowService{

	@Resource
	private MainShowDao mainShowDao;
	
	@Resource
	private SpkDao spkDao;
	
	/**
	 * 根据字段sywzdm来查询显示位置的商品，调用该方法的有：Initcomponet.java
	 * @return
	 */
	public List<MainShow> findListBySywzdm(Map<String, Object> map) {
		List<MainShow> findListBySywzdm = mainShowDao.findListBySywzdm(map);
		for (MainShow mainShow : findListBySywzdm) {
			mainShow.setSpk(spkDao.getOne(mainShow.getSpkid()));
		}
		return findListBySywzdm;
	}
	
	
	
}
