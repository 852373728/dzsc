package com.sun.dao;

import java.util.List;

import com.sun.entity.Qylx;

public interface QylxDao {

	/**
	 * 没有任何条件的全部查询
	 * @return
	 */
	public List<Qylx> findList();
}
