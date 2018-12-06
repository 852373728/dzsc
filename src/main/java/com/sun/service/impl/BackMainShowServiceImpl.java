package com.sun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackMainShowDao;
import com.sun.dao.BackSpkDao;
import com.sun.entity.MainShow;
import com.sun.service.BackMainShowService;

@Service("backMainShowService")
public class BackMainShowServiceImpl implements BackMainShowService{
	
	@Resource
	private BackMainShowDao backMainShowDao;
	@Resource
	private BackSpkDao backSpkDao;

	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<MainShow> list(Map<String, Object> map){
		List<MainShow> mainShowList = backMainShowDao.list(map);
		Map<String, Object> map1=new HashMap<String, Object>();
		for (MainShow mainShow : mainShowList) {
			map1.put("id", mainShow.getSpkid());
			mainShow.setSpk(backSpkDao.getOne(map1));
		}
		return mainShowList;
	}
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return backMainShowDao.total(map);
	}
	public boolean add(MainShow mainShow) {
		try {
			backMainShowDao.add(mainShow);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean update(MainShow mainShow) {
		try {
			backMainShowDao.update(mainShow);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delete(String ids) {
		try {
			String[] split = ids.split(",");
			for (String string : split) {
				backMainShowDao.delete(Integer.parseInt(string));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
