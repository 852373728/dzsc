package com.sun.service;

import java.util.List;

import com.sun.entity.Qylx;

public interface QylxService {

	/**
	 * 没有任何条件的全部查询
	 * @return
	 */
	public List<Qylx> findList();
}
