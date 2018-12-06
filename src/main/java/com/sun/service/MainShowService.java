package com.sun.service;

import java.util.List;
import java.util.Map;

import com.sun.entity.MainShow;

public interface MainShowService {

	public List<MainShow> findListBySywzdm(Map<String, Object> map);
}
