package com.sun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackHuoDongDao;
import com.sun.dao.BackSpkDao;
import com.sun.dao.BackThreeBarDao;
import com.sun.dao.BackTwoBarDao;
import com.sun.entity.HuoDong;
import com.sun.service.BackHuoDongService;

@Service("backHuoDongService")
public class BackHuoDongServiceImpl implements BackHuoDongService{

	@Resource
	private BackHuoDongDao backHuoDongDao;
	@Resource
	private BackSpkDao backSpkDao;
	@Resource
	private BackTwoBarDao backTwoBarDao;
	@Resource
	private BackThreeBarDao backThreeBarDao;
	
	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<HuoDong> list(Map<String, Object> map){
		List<HuoDong> huoDongList = backHuoDongDao.list(map);
		Map<String, Object> map1=new HashMap<String, Object>();
		for (HuoDong huoDong : huoDongList) {
			map1.put("id", huoDong.getSpkId());
			huoDong.setSpk(backSpkDao.getOne(map1));
			huoDong.setThreeBar(backThreeBarDao.getOne(huoDong.getThreeBarId()));
		}
		return huoDongList;
	}
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		 return backHuoDongDao.total(map);
	}
	
	public boolean add(HuoDong huoDong) {
		try {
			huoDong.setTwoBarName(backTwoBarDao.getOne(huoDong.getTwoBarId()).getName());
			backHuoDongDao.add(huoDong);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean update(HuoDong huoDong) {
		try {
			huoDong.setTwoBarName(backTwoBarDao.getOne(huoDong.getTwoBarId()).getName());
			backHuoDongDao.update(huoDong);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delete(String ids) {
		try {
			String[] split = ids.split(",");
			for (String string : split) {
				backHuoDongDao.delete(Integer.parseInt(string));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public HuoDong getOne(Map<String, Object> map) {
		return backHuoDongDao.getOne(map);
	}
}
