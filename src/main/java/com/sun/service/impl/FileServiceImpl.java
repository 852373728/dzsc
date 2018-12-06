package com.sun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.FileDao;
import com.sun.entity.T_File;
import com.sun.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService{

	@Resource
	private FileDao fileDao;
	
	public void add(T_File file) {
		fileDao.add(file);
	}

	public List<T_File> list(Map<String, Object> map) {
		return fileDao.list(map);
	}

	public Long total(Map<String, Object> map) {
		return fileDao.total(map);
	}

	public boolean delete(Integer id) {
		fileDao.delete(id);
		return true;
	}
}
