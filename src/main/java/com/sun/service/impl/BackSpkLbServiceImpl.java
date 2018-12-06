package com.sun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.BackSpkLbDao;
import com.sun.entity.SpkLb;
import com.sun.service.BackSpkLbService;
import com.sun.util.FormatMath;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("backSpkLbService")
public class BackSpkLbServiceImpl implements BackSpkLbService{
	
	@Resource
	private BackSpkLbDao backSpkLbDao;
	/**
	 * 后台商品分类的查询，树形表格
	 * @param lbparent
	 * @return
	 */
	public List<SpkLb> findByLbParent(String lbparent){
		return backSpkLbDao.findByLbParent(lbparent);
	}

	public boolean update(String data){
		try {
			JSONArray jsonArray = JSONArray.fromObject(data); 
			Map<String, Object> map= new HashMap<String, Object>();
			for (Object object : jsonArray) {
				JSONObject json=(JSONObject) object;
				map.put("show", json.get("show"));
				map.put("xh",FormatMath.format(json.getString("xh"), "\\d*", "0"));
				map.put("id", json.get("id"));
				backSpkLbDao.update(map);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * combobox
	 * @param map
	 * @return
	 */
	public List<SpkLb> list(Map<String, Object> map){
		return backSpkLbDao.list(map);
	}
	
	public SpkLb getOnebyLbdm(String lbdm) {
		return backSpkLbDao.getOnebyLbdm(lbdm);
	}
}
