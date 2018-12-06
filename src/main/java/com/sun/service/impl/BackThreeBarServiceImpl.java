package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackThreeBarDao;
import com.sun.dao.BackTwoBarDao;
import com.sun.entity.ThreeBar;
import com.sun.service.BackThreeBarService;

@Service("backThreeBarService")
public class BackThreeBarServiceImpl implements BackThreeBarService{

	@Resource
	private BackThreeBarDao backThreeBarDao;
	@Resource
	private BackTwoBarDao BackTwoBarDao;
	
	public List<ThreeBar> list(Map<String, Object> map){
		List<ThreeBar> threeBarList = backThreeBarDao.list(map);
		for (ThreeBar threeBar : threeBarList) {
			threeBar.setTwoBar(BackTwoBarDao.getOne(threeBar.getTwoBarId()));
		}
		return threeBarList;
	}
	
	public Long total(Map<String, Object> map) {
		return backThreeBarDao.total(map);
	}
	
	public boolean add(ThreeBar threeBar) {
		try {
			backThreeBarDao.add(threeBar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(ThreeBar threeBar) {
		try {
			backThreeBarDao.update(threeBar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(String ids){
		try {
			String[] split = ids.split(",");
			for (String string : split) {
				backThreeBarDao.delete(Integer.parseInt(string));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 根据导航条二级分类查询
	 * @param twoBarId
	 * @return
	 */
	public List<ThreeBar> listByTwoBar(Integer twoBarId){
		return backThreeBarDao.listByTwoBar(twoBarId);
	}
}
