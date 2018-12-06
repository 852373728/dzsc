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
	 * �ר���ֲ�ͼƬ����ʾ
	 * @return
	 */
	public List<ThreeBar> findCarousel() {
		return threeBarDao.findCarousel();
	}
	
	/**
	 * �ר��ҳ�桰ר������Ŀ
	 * @return
	 */
	public List<ThreeBar> zthd(){
		return threeBarDao.zthd();
	}

	/**
	 * �����������ķ�ҳ��ѯ
	 * @param map
	 * @return
	 */
	public List<ThreeBar> fenye(Map<String, Object> map){
		return threeBarDao.fenye(map);
	}
	
	/**
	 * ����������������
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return threeBarDao.total(map);
	}

}
