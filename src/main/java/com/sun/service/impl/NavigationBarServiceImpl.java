package com.sun.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.HuoDongDao;
import com.sun.dao.NavigationBarDao;
import com.sun.dao.SpkDao;
import com.sun.dao.TuiJianDao;
import com.sun.dao.TwoBarDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.HuoDong;
import com.sun.entity.Kh;
import com.sun.entity.NavigationBar;
import com.sun.entity.Spk;
import com.sun.entity.TuiJian;
import com.sun.entity.TwoBar;
import com.sun.service.NavigationBarService;
import com.sun.util.StringUtil;

@Service("navigationBarService")
public class NavigationBarServiceImpl implements NavigationBarService {

	@Resource
	private NavigationBarDao navigationBarDao;
	
	@Resource
	private TwoBarDao twoBarDao;
	
	@Resource
	private TuiJianDao tuiJianDao;
	
	@Resource
	private HuoDongDao huoDongDao;
	
	@Resource
	private SpkDao spkDao;
	@Resource
	private UseKhDao useKhDao;
	
	/**
	 * 查询导航条全部信息，调用该方法的有：Initcomponet.java
	 */
	public List<NavigationBar> finList() {
		return navigationBarDao.finList();
	}

	/**
	 * 首页推荐品种和最新活动 HomePageController.java
	 * @return
	 */
	public List<NavigationBar> hdatj(boolean loggedIn,Kh kh) {
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> discountMap=new HashMap<String, Object>();
		map.put("rowSize", 3);
		List<NavigationBar> hdatj = navigationBarDao.hdatj();
		for (NavigationBar navigationBar : hdatj) {
			map.put("barid", navigationBar.getId());
			List<TwoBar> twoBarList = twoBarDao.findByBarId(map);
			for (TwoBar twoBar : twoBarList) {
				List<TuiJian> tuiJianList = tuiJianDao.findBytwoBarName(twoBar.getName());
				if(tuiJianList!=null && tuiJianList.size()>0) {
					Iterator<TuiJian> iterator = tuiJianList.iterator();
					while(iterator.hasNext()) {
						TuiJian tuiJian = iterator.next();
						if(loggedIn) {
							Spk spk1 = spkDao.getOneUser(tuiJian.getSpkId());
							if(StringUtil.isNotEmpty(spk1.getQy_xz())) {
								List<String> list = useKhDao.listK(spk1.getQy_xz());
								if(!list.contains(kh.getKhdm())) {
									iterator.remove();
									continue;
								}
							}
							discountMap.put("spdm", spk1.getSpdm());
							discountMap.put("khdm", kh.getKhdm());
							Float discount = spkDao.discount(discountMap);
							if(discount!=null && discount>0) {
								spk1.setXsjg(discount);
							}
							
							tuiJian.setSpk(spk1);
						}else {
							tuiJian.setSpk(spkDao.getOne(tuiJian.getSpkId()));
						}
					}
				}
				twoBar.setTuiJianList(tuiJianList);
				List<HuoDong> huoDongList = huoDongDao.findByTwoBarId(twoBar.getId());
				if(huoDongList!=null && huoDongList.size()>0) {
					Iterator<HuoDong> iterator = huoDongList.iterator();
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
				}
				twoBar.setHuoDongList(huoDongList);
			}
			navigationBar.setTwoBarList(twoBarList);
			
			if(navigationBar.getId()==4) {
				navigationBar.setTuiJianList(tuiJianDao.findByhpCarosel());
			}else{
				navigationBar.setHuoDongList(huoDongDao.findByhpCarosel());
			}
		}
		return hdatj;
	}

}
