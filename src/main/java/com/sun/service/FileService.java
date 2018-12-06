package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.T_File;

public interface FileService {

	public void add(T_File file);
	
	public List<T_File> list(Map<String, Object> map);
	
	public Long total(Map<String, Object> map);
	
	public boolean delete(Integer id);
}
