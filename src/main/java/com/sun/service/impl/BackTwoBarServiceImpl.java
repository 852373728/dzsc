package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackNavigationBarDao;
import com.sun.dao.BackTwoBarDao;
import com.sun.entity.TwoBar;
import com.sun.service.BackTwoBarService;

@Service("backTwoBarService")
public class BackTwoBarServiceImpl implements BackTwoBarService{

	@Resource
	private BackTwoBarDao backTwoBarDao;
	@Resource
	private BackNavigationBarDao backNavigationBarDao;
	
	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<TwoBar> list(Map<String, Object> map){
		List<TwoBar> twoBarList = backTwoBarDao.list(map);
		for (TwoBar twoBar : twoBarList) {
			twoBar.setNavigationBar(backNavigationBarDao.getOne(twoBar.getBarId()));
		}
		return twoBarList;
	}
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return backTwoBarDao.total(map);
	}
	
	public boolean add(TwoBar twoBar) {
		try {
			backTwoBarDao.add(twoBar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(TwoBar twoBar) {
		try {
			backTwoBarDao.update(twoBar);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean delete(String ids) {
		try {
			String[] id = ids.split(",");
			for (String string : id) {
				backTwoBarDao.delete(Integer.parseInt(string));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 根据barid查询list
	 * @param barid
	 * @return
	 */
	public List<TwoBar> findByBarId(Integer barid){
		return backTwoBarDao.findByBarId(barid);
	}
}
