package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackKhDao;
import com.sun.entity.Kh;
import com.sun.service.BackKhService;

@Service("backKhService")
public class BackKhServiceImpl implements BackKhService{
	
	@Resource
	private BackKhDao backKhDao;

	/**
	 * 后台list
	 * @param map
	 * @return
	 */
	public List<Kh> list(Map<String, Object> map){
		return backKhDao.list(map);
	}
	
	/**
	 * 后台条数
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return backKhDao.total(map);
	}

	public boolean update(Kh kh) {
		try {
			backKhDao.update(kh);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(String emails) {
		try {
			String[] split = emails.split(",");
			for (String email : split) {
				backKhDao.delete(email);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
