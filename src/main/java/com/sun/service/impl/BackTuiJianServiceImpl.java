package com.sun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackSpkDao;
import com.sun.dao.BackTuiJianDao;
import com.sun.dao.BackTwoBarDao;
import com.sun.entity.TuiJian;
import com.sun.service.BackTuiJianService;

@Service("backTuiJianService")
public class BackTuiJianServiceImpl implements BackTuiJianService{

	@Resource
	private BackTuiJianDao backTuiJianDao;
	@Resource
	private BackSpkDao backSpkDao;
	@Resource
	private BackTwoBarDao BackTwoBarDao;
	
	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<TuiJian> list(Map<String, Object> map){
		List<TuiJian> tuiJianList = backTuiJianDao.list(map);
		Map<String, Object> map1=new HashMap<String, Object>();
		for (TuiJian tuiJian : tuiJianList) {
			map1.put("id", tuiJian.getSpkId());
			tuiJian.setSpk(backSpkDao.getOne(map1));
		}
		return tuiJianList;
	}
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return backTuiJianDao.total(map);
	}
	
	/*public boolean add(TuiJian tuiJian) {
		try {
			backTuiJianDao.add(tuiJian);
			return true;
		} catch (Exception e) {
			return false;
		}
	}*/
	
	public boolean update(TuiJian tuiJian) {
		try {
			backTuiJianDao.update(tuiJian);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(String ids) {
		try {
			String[] split = ids.split(",");
			for (String string : split) {
				backTuiJianDao.delete(Integer.parseInt(string));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
