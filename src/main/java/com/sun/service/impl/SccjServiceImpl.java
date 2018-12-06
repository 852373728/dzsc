package com.sun.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.HuoDongDao;
import com.sun.dao.SccjDao;
import com.sun.dao.SpkDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.Kh;
import com.sun.entity.Sccj;
import com.sun.entity.Spk;
import com.sun.service.SccjService;
import com.sun.util.StringUtil;

@Service("sccjService")
public class SccjServiceImpl  implements SccjService{

	@Resource
	private SccjDao sccjDao;
	
	@Resource
	private SpkDao spkDao;
	@Resource
	private HuoDongDao huoDongDao;
	@Resource
	private UseKhDao useKhDao;
	
	
	/**
	 * 推荐页面的厂家显示
	 * @return
	 */
	public List<Sccj> tuiJian(){
		return sccjDao.tuiJian();
	}
	
	/**
	 * 品牌专区上面的12个厂家显示，根据字段pinpaiShow=1查询
	 * @return
	 */
	public List<Sccj> pinpaiShow(){
		return sccjDao.pinpaiShow();
	}
	
	/**
	 * 品牌专区厂家分页查询
	 * @param map
	 * @return
	 */
	public List<Sccj> fenye(Map<String, Object> map,boolean loggedIn,Kh kh){
		List<Sccj> sccjList = sccjDao.fenye(map);
		Map<String, Object> map1=new HashMap<String, Object>();
		Map<String, Object> discountMap=new HashMap<String, Object>();
		map1.put("rownum_sccj", 1);
		for (Sccj sccj : sccjList) {
			map1.put("spdmlist", sccj.getSpdmList());
			if(loggedIn) {
				List<Spk> spkList = spkDao.findBySCCJ1User(map1);
				Iterator<Spk> iterator = spkList.iterator();
				while(iterator.hasNext()) {
					Spk spk = iterator.next();
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
				}
				sccj.setSpkList(spkList);
			}else {
				sccj.setSpkList(spkDao.findBySCCJ1(map1));
			}
		}
		return sccjList;
	}
	
	/**
	 * 品牌专区厂家总条数的显示
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return sccjDao.total(map);
	}
	
	/**
	 * 根据厂家名称获得该厂家实体
	 * @param cjmc
	 * @return
	 */
	public Sccj getSccj(String cjmc,Map<String, Object> map,boolean loggedIn,Kh kh) {
		Sccj sccj = sccjDao.getSccj(cjmc);
		if(sccj!=null) {
			map.put("spdmlist", sccj.getSpdmList());
			if(loggedIn) {
				Map<String, Object> discountMap=new HashMap<String, Object>();
				List<Spk> spkList = spkDao.findBySCCJ1User(map);
				Iterator<Spk> iterator = spkList.iterator();
				while(iterator.hasNext()) {
					Spk spk = iterator.next();
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
					spk.setHuoDong(huoDongDao.getBySpkId(spk.getId()));
				}
				sccj.setSpkList(spkList);
			}else {
				List<Spk> spkList = spkDao.findBySCCJ1(map);
				for (Spk spk : spkList) {
					spk.setHuoDong(huoDongDao.getBySpkId(spk.getId()));
				}
				sccj.setSpkList(spkList);
			}
			sccj.setSpkTotal(spkDao.findBySCCJ1Count(map));
		}
		return sccj;
	}
}
