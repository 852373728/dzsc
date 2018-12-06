package com.sun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.ZzzlDao;
import com.sun.entity.Zzzl;

@Service
public class ZzzlService {

	@Resource
	private ZzzlDao zzzlDao;
	
	public Zzzl judge(String khdm) {
		return zzzlDao.judge(khdm);
	}
	
	
}
