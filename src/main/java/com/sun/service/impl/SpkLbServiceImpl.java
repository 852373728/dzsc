package com.sun.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.MainTypeShowDao;
import com.sun.dao.SccjDao;
import com.sun.dao.SpkDao;
import com.sun.dao.SpkLbDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.Kh;
import com.sun.entity.MainTypeShow;
import com.sun.entity.Spk;
import com.sun.entity.SpkLb;
import com.sun.service.SpkLbService;
import com.sun.util.StringUtil;

@Service("spkLbService")
public class SpkLbServiceImpl implements SpkLbService{
	
	@Resource
	private SpkLbDao spkLbDao;
	@Resource
	private MainTypeShowDao mainTypeShowDao;
	@Resource
	private SccjDao sccjDao;
	@Resource
	private SpkDao spkDao;
	@Resource
	private UseKhDao useKhDao;

	/**
	 * 根据字段lbparent来查询集合，递归查询 Initcomponet.java
	 * @param lbparent
	 * @return
	 */
	public List<SpkLb> findByLbParent(String lbparent) {
		return spkLbDao.findByLbParent(lbparent);
	}

	/**
	 * 用于首页药品等栏目下的信息查询, HomePageController.home
	 * @return
	 */
	public List<SpkLb> findLevel(boolean loggedIn,Kh kh) {
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("lbparent", "z");
		map.put("rowSize", 5);
		Map<String, Object> map1 =new HashMap<String, Object>();
		map1.put("homepageshow", 1);
		map1.put("rownum", 5);
		Map<String, Object> map2 =new HashMap<String, Object>();
		map2.put("homepageshow", 2);
		map2.put("rownum", 2);
		Map<String, Object> map3 =new HashMap<String, Object>();
		map3.put("homepageshow", 3);
		map3.put("rownum", 5);
		Map<String, Object> discountMap=new HashMap<String, Object>();
		List<SpkLb> FirstList = spkLbDao.findLevel(map);
		for (SpkLb spkLb : FirstList) {
			map.put("lbparent", spkLb.getLbdm());
			map.put("rowSize", 7);
			List<SpkLb> TwoList = spkLbDao.findLevel(map);
			for (SpkLb spkLb2 : TwoList) {
				map1.put("splbDm", spkLb2.getLbdm());
				List<MainTypeShow> MainTypeShowList1 = mainTypeShowDao.findhpBylbDm(map1);
				Iterator<MainTypeShow> iterator = MainTypeShowList1.iterator();
				while (iterator.hasNext()) {
					MainTypeShow mainTypeShow = iterator.next();
					if(loggedIn) {
						Spk spk = spkDao.getOneUser(mainTypeShow.getSpkId());
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
						mainTypeShow.setSpk(spk);
					}else {
						mainTypeShow.setSpk(spkDao.getOne(mainTypeShow.getSpkId()));
					}
				
				}
				spkLb2.setMainTypeShowList1(MainTypeShowList1);
			}
			spkLb.setSpklbList(TwoList);
			map2.put("splbDm", spkLb.getLbdm());
			List<MainTypeShow> MainTypeShowList2 = mainTypeShowDao.findhpBylbDm(map2);
			for (MainTypeShow mainTypeShow : MainTypeShowList2) {
				mainTypeShow.setSpk(spkDao.getOne(mainTypeShow.getSpkId()));
			}
			spkLb.setMainTypeShowList2(MainTypeShowList2);
			map3.put("splbDm", spkLb.getLbdm());
			List<MainTypeShow> MainTypeShowList3 = mainTypeShowDao.findhpBylbDm(map3);
			for (MainTypeShow mainTypeShow : MainTypeShowList3) {
				mainTypeShow.setSpk(spkDao.getOne(mainTypeShow.getSpkId()));
			}
			spkLb.setMainTypeShowList3(MainTypeShowList3);
			spkLb.setSccjList(sccjDao.findBysplbdm(spkLb.getLbdm()));
			List<SpkLb> hotTwo = spkLbDao.findByLbParent(spkLb.getLbdm());
			StringBuffer sb=new StringBuffer();
			for (SpkLb spkLb2 : hotTwo) {
				sb.append(","+spkLb2.getLbdm());
			}
			String[] split = sb.toString().replaceFirst(",", "").split(",");
			Map<String, Object> map4 =new HashMap<String, Object>();
			map4.put("array", split);
			map4.put("rownum", 5);
			map4.put("px", "xlph");
			if(loggedIn) {
				List<Spk> spklist = spkDao.hotSaleUser(map4);
				Iterator<Spk> iterator = spklist.iterator();
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
				spkLb.setSpkList(spklist);
			}else {
				spkLb.setSpkList(spkDao.hotSale(map4));
			}
		}
		return FirstList;
	}

}
