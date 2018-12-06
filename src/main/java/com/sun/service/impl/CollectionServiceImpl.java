package com.sun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.CollectionDao;
import com.sun.dao.HuoDongDao;
import com.sun.dao.SpkDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.Collect;
import com.sun.entity.Kh;
import com.sun.entity.Spk;
import com.sun.service.CollectionService;
import com.sun.util.StringUtil;

@Service("collectionService")
public class CollectionServiceImpl implements CollectionService{

	@Resource
	private CollectionDao collectionDao;
	@Resource
	private SpkDao spkDao;
	@Resource
	private HuoDongDao huoDongDao;
	@Resource
	private UseKhDao useKhDao;
	
	
	public boolean add(Collect collect) {
		try {
			collectionDao.add(collect);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Collect> findByUserName(Kh kh) {
		List<Collect> collectionList = collectionDao.findByUserName(kh.getEmail());
		Map<String, Object> map1=new HashMap<String, Object>();
		Map<String, Object> discountMap=new HashMap<String, Object>();
		for (Collect collection : collectionList) {
			map1.put("spdm", collection.getSpdm());
			Spk spk = spkDao.getOneUserBymap(map1);
			if(spk!=null) {
				discountMap.put("spdm", spk.getSpdm());
				discountMap.put("khdm", kh.getKhdm());
				Float discount = spkDao.discount(discountMap);
				if(discount!=null && discount>0) {
					spk.setXsjg(discount);
				}
				if(StringUtil.isNotEmpty(spk.getQy_xz())) {
					List<String> list = useKhDao.listK(spk.getQy_xz());
					if(!list.contains(kh.getKhdm())) {
						spk.setXsjg(-1);
						spk.setJ_xj(-1);
						spk.setJ_zj(-1);
					}
				}
				spk.setHuoDong(huoDongDao.getBySpkId(spk.getId()));
			}
			collection.setSpk(spk);
		}
		return collectionList;
	}

	public boolean delete(Integer id) {
		try {
			collectionDao.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Long exit(Map<String, Object> map) {
		return collectionDao.exit(map);
	}
	
	/**
	 * 用来比对用户收藏的商品变颜色
	 */
	public List<Collect> findByUserName1(String userName) {
		return collectionDao.findByUserName(userName);
	}

}
