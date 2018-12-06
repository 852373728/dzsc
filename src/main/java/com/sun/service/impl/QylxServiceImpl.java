package com.sun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.QylxDao;
import com.sun.entity.Qylx;
import com.sun.service.QylxService;

@Service("QylxService")
public class QylxServiceImpl implements QylxService{

	@Resource
	private QylxDao QylxDao;
	
	public List<Qylx> findList() {
		return QylxDao.findList();
	}
	
}
