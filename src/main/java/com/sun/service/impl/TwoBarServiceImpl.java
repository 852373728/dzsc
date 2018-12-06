package com.sun.service.impl;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.HuoDongDao;
import com.sun.dao.SpkDao;
import com.sun.dao.TuiJianDao;
import com.sun.dao.TwoBarDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.HuoDong;
import com.sun.entity.Kh;
import com.sun.entity.Spk;
import com.sun.entity.TuiJian;
import com.sun.entity.TwoBar;
import com.sun.service.TwoBarService;
import com.sun.util.StringUtil;

@Service("twoBarService")
public class TwoBarServiceImpl implements TwoBarService{

	@Resource
	private TwoBarDao twoBarDao;
	
	@Resource
	private TuiJianDao tuiJianDao;
	
	@Resource
	private SpkDao spkDao;
	@Resource
	private UseKhDao useKhDao;
	@Resource
	private HuoDongDao huoDongDao;
	
	
	/**
	 * 推荐页面的二级类查询，新品推荐等
	 * @param map
	 * @return
	 */
	public List<TwoBar> findByBarId(boolean loggedIn,Kh kh){
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("barid", 4);
		map.put("rowSize", 3);
		List<TwoBar> twoBarList = twoBarDao.findByBarId(map);
		Map<String, Object> discountMap=new HashMap<String, Object>();
		for (TwoBar twoBar2 : twoBarList) {
			List<TuiJian> tuijianList = tuiJianDao.findBytwoBarName(twoBar2.getName());
			Iterator<TuiJian> iterator = tuijianList.iterator();
			while(iterator.hasNext()) {
				TuiJian tuiJian2 = iterator.next();
				if(loggedIn) {
					Spk spk = spkDao.getOneUser(tuiJian2.getSpkId());
					if(StringUtil.isNotEmpty(spk.getQy_xz())) {
						List<String> list = useKhDao.listK(spk.getQy_xz());
						if(!list.contains(kh.getKhdm())) {
							iterator.remove();
							continue;
						}
					}
					discountMap.put("spdm", spk.getSpdm());
					discountMap.put("khdm", kh.getKhdm());
					Float discount = spkDao.discount(discountMap);
					if(discount!=null && discount>0) {
						spk.setXsjg(discount);
					}
					tuiJian2.setSpk(spk);
				}else {
					tuiJian2.setSpk(spkDao.getOne(tuiJian2.getSpkId()));
				}
			
			}
			twoBar2.setTuiJianList(tuijianList);
			TuiJian tuijian = tuiJianDao.findByshow2(twoBar2.getName());
			if(tuijian!=null) {
				tuijian.setSpk(spkDao.getOne(tuijian.getSpkId()));
			}
			twoBar2.setTuiJian(tuijian);
		}
		return twoBarList;
	}


	public List<TwoBar> findByHuodong(boolean loggedIn, Kh kh) {
		List<TwoBar> huodongTwoList = twoBarDao.findByHuodong();
		Map<String, Object> discountMap=new HashMap<String, Object>();
		for (TwoBar twoBar : huodongTwoList) {
			List<HuoDong> hdyList = huoDongDao.hdyList(twoBar.getId());
			Iterator<HuoDong> iterator = hdyList.iterator();
			while(iterator.hasNext()) {
				HuoDong huoDong = iterator.next();
				if(loggedIn) {
					Spk spk = spkDao.getOneUser(huoDong.getSpkId());
					if(StringUtil.isNotEmpty(spk.getQy_xz())) {
						List<String> list = useKhDao.listK(spk.getQy_xz());
						if(!list.contains(kh.getKhdm())) {
							iterator.remove();
							continue;
						}
					}
					discountMap.put("spdm", spk.getSpdm());
					discountMap.put("khdm", kh.getKhdm());
					Float discount = spkDao.discount(discountMap);
					if(discount!=null && discount>0) {
						spk.setXsjg(discount);
					}
					huoDong.setSpk(spk);
				}else {
					huoDong.setSpk(spkDao.getOne(huoDong.getSpkId()));
				}
			}
			twoBar.setHuoDongList(hdyList);
		}
		return huodongTwoList;
	}
	
	
	
	

}
