package com.sun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackMainTypeShowDao;
import com.sun.dao.BackSpkDao;
import com.sun.dao.BackSpkLbDao;
import com.sun.entity.MainTypeShow;
import com.sun.service.BackMainTypeShowService;

@Service("backMainTypeShowService")
public class BackMainTypeShowServiceImpl implements BackMainTypeShowService{

	@Resource
	private BackMainTypeShowDao backMainTypeShowDao;
	@Resource
	private BackSpkDao backSpkDao;
	@Resource
	private BackSpkLbDao backSpkLbDao;
	
	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<MainTypeShow> list(Map<String, Object> map){
		List<MainTypeShow> mainTypeShowList = backMainTypeShowDao.list(map);
		Map<String, Object> map1=new HashMap<String, Object>();
		for (MainTypeShow mainTypeShow : mainTypeShowList) {
			map1.put("id", mainTypeShow.getSpkId());
			mainTypeShow.setSpk(backSpkDao.getOne(map1));
			mainTypeShow.setSpkLb(backSpkLbDao.getOnebyLbdm(mainTypeShow.getSplbDm()));
		}
		return mainTypeShowList;
	}
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return backMainTypeShowDao.total(map);
	}
	public boolean add(MainTypeShow mainTypeShow) {
		try {
			backMainTypeShowDao.add(mainTypeShow);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean update(MainTypeShow mainTypeShow) {
		try {
			backMainTypeShowDao.update(mainTypeShow);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delete(String ids) {
		try {
			String[] split = ids.split(",");
			for (String string : split) {
				backMainTypeShowDao.delete(Integer.parseInt(string));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
