package com.sun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.TuiJianDao;
import com.sun.entity.TuiJian;
import com.sun.service.TuiJianService;

@Service("tuiJianService")
public class TuiJianServiceImpl implements TuiJianService{

	@Resource
	private TuiJianDao tuiJianDao;
	
	/**
	 * 根据showCarousel=1字段查询，推荐品种页面的轮播
	 * @return
	 */
	public List<TuiJian> carousel() {
		return tuiJianDao.carousel();
	}

}
