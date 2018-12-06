package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.HuoDongDao;
import com.sun.dao.SpkDao;
import com.sun.dao.ThreeBarDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.ThreeBar;
import com.sun.service.ThreeBarService;

@Service("threeBarService")
public class ThreeBarServiceImpl implements ThreeBarService{

	@Resource
	private ThreeBarDao threeBarDao;
	@Resource
	private HuoDongDao huoDongDao;
	@Resource
	private SpkDao spkDao;
	@Resource
	private UseKhDao useKhDao;
	
	/**
	 * 活动专区轮播图片的显示
	 * @return
	 */
	public List<ThreeBar> findCarousel() {
		return threeBarDao.findCarousel();
	}
	
	/**
	 * 活动专区页面“专题活动”栏目
	 * @return
	 */
	public List<ThreeBar> zthd(){
		return threeBarDao.zthd();
	}

	/**
	 * 导航条三级的分页查询
	 * @param map
	 * @return
	 */
	public List<ThreeBar> fenye(Map<String, Object> map){
		return threeBarDao.fenye(map);
	}
	
	/**
	 * 导航条三级的总数
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return threeBarDao.total(map);
	}

}
