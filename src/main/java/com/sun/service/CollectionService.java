package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.Collect;
import com.sun.entity.Kh;

public interface CollectionService {
	
	public boolean add(Collect collect);
	
	public List<Collect> findByUserName(Kh kh);
	
	public boolean delete(Integer id);
	
	public Long exit(Map<String, Object> map);
	
	public List<Collect> findByUserName1(String userName);

}
