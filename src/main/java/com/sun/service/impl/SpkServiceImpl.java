package com.sun.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.HuoDongDao;
import com.sun.dao.JinxqDao;
import com.sun.dao.SpkDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.HuoDong;
import com.sun.entity.Kh;
import com.sun.entity.Spk;
import com.sun.service.SpkService;
import com.sun.util.StringUtil;

@Service("spkService")
public class SpkServiceImpl implements SpkService{

	@Resource
	private SpkDao spkDao;
	@Resource
	private HuoDongDao huoDongDao;
	@Resource
	private UseKhDao useKhDao;
	@Resource
	private JinxqDao jinxqDao;
	

	/**
	 * 用户未登录时，通过spkID获得实体，某些字段不予展示
	 * @param id
	 * @return
	 */
	public Spk getOne(Integer id) {
		return spkDao.getOne(id);
	}
	
	/**
	 * 用户已登录，通过spkID获得实体，展示的字段多些，其它没区别
	 * @param id
	 * @return
	 */
	public Spk getOneUser(Integer id,Kh kh) {
		Spk spk = spkDao.getOneUser(id);
		if(spk!=null) {
			Map<String, Object> discountMap=new HashMap<String, Object>();
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
					spk.setKysl(-1);
					spk.setLsdj(0);
					spk.setCb4(0);
				}
			}
		}
		return spk;
	}
	
	/**
	 * 全部商品销量排行查询,HomePageController.home
	 * @return
	 */
	public List<Spk> sale() {
		return spkDao.sale();
	}

	/**
	 * 全部商品点击排行查询,HomePageController.home
	 * @return
	 */
	public List<Spk> click() {
		return spkDao.click();
	}

	/**
	 * 可供页面的商品查询 HomePageController.java 推荐品种更多页面，活动专区更多页面
	 * @param map
	 * @return
	 */
	public List<Spk> findSpkList(Map<String, Object> map,boolean loggedIn,Kh kh) {
		if(loggedIn) {
			Map<String, Object> discountMap=new HashMap<String, Object>();
			List<Spk> spkList = spkDao.findSpkListUser(map);
			Iterator<Spk> iterator = spkList.iterator();
			while(iterator.hasNext()){
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
			return spkList;
		}else {
			List<Spk> spkList = spkDao.findSpkList(map);
			for (Spk spk : spkList) {
				HuoDong huoDong = huoDongDao.getBySpkId(spk.getId());
				if(huoDong!=null) {
					huoDong.setHuoDongContent("登陆可见");
					spk.setHuoDong(huoDong);
				}
			}
			return spkList;
		}
	}

	/**
	 * 可供页面的商品总条数查询
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return spkDao.total(map);
	}

	/**
	 * 可供页面展示的商品所属的二级分类列表
	 * @param map
	 * @return
	 */
	public List<Spk> findSplbTwo(Map<String, Object> map) {
		return spkDao.findSplbTwo(map);
	}
	
	/**
	 * 可供页面展示的商品所属的一级分类列表
	 * @param map
	 * @return
	 */
	public List<Spk> findSplbOne(Map<String, Object> map){
		return spkDao.findSplbOne(map);
	}
	
	/**
	 * 可供页面展示的商品所属的生产厂家，固定查询15个厂家，排序规则参照sccj表
	 * @param map
	 * @return
	 */
	public List<Spk> findSccj(Map<String, Object> map){
		return spkDao.findSccj(map);
	}
	
	/**
	 * 可供页面展示的商品所属剂型，去掉了空的
	 * @param map
	 * @return
	 */
	public List<Spk> findJx(Map<String, Object> map){
		return spkDao.findJx(map);
	}

	/**
	 * 可供页面展示的商品所属处方类型，去掉了空的
	 * @param map
	 * @return
	 */
	public List<Spk> findXz(Map<String, Object> map){
		return spkDao.findXz(map);
	}
	
	/**
	 * 可供页面展示的商品所属医保类型，去掉了空的
	 * @param map
	 * @return
	 */
	public List<Spk> findyl(Map<String, Object> map){
		return spkDao.findyl(map);
	}
	
	/**
	 * 推荐品种更多页面的“推荐类型”条件
	 * @param map
	 * @return
	 */
	public List<Spk> findTwoBar(Map<String, Object> map){
		return spkDao.findTwoBar(map);
	}

	/**
	 * 热销新品
	 * @return
	 */
	public List<Spk> hotNew(){
		return spkDao.hotNew();
	}
	
	/**
	 * 商品详情页面，右边的热销，新品查询
	 * @param map
	 * @return
	 */
	public List<Spk> goodRight(Map<String, Object> map,boolean loggedIn,Kh kh){
		if(loggedIn) {
			List<Spk> spkList = spkDao.goodRightUser(map);
			Map<String, Object> discountMap=new HashMap<String, Object>();
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
			return spkList;
		}else {
			return spkDao.goodRight(map);
		}
	}
	
	/**
	 * 根据厂家名称查找商品
	 * @param SCCJ1
	 * @return
	 */
	public List<Spk> findBySCCJ1(Map<String, Object> map,boolean loggedIn,Kh kh){
		if(loggedIn) {
			List<Spk> spkList = spkDao.findBySCCJ1User(map);
			Map<String, Object> discountMap=new HashMap<String, Object>();
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
			return spkList;
		}else {
			return spkDao.findBySCCJ1(map);
		}
	}
	
	/**
	 * 点击排行和销量排行的修改
	 * @param map
	 */
	public void editph(Map<String, Object> map) {
		spkDao.editph(map);
	}
	
	public Spk getOneUserBymap(Map<String, Object> map) {
		return spkDao.getOneUserBymap(map);
	}
	
	/**
	 * 商品的可用数量，用户购买进行数量验证，数量不足不能购买
	 * @param spdm
	 * @return
	 */
	public String kysl(String spdmStrs,String sls,Kh kh,String spphs) {
		String[] spdm = spdmStrs.split(",");
		String[] sl = sls.split(",");
		String[] spph = spphs.split(",");
		if(spdm.length!=sl.length || spdm.length!=spph.length) {
			return "数据有误！";
		}
		for(int i=0;i<spdm.length;i++) {
			if(Integer.parseInt(sl[i])<=0) {
				return "购买数量不能为0！";
			}
			if(spph[i].equals("sun")) {
				Spk spk = spkDao.kysl(spdm[i]);
				if(spk==null) {
					return "商品不存在";
				}
				if(spk.getXsjg()<=0.0) {
					return spk.getSpmc()+"价格有误，暂时无法购买";
				}
				if(StringUtil.isNotEmpty(spk.getQy_xz())) {
					List<String> list = useKhDao.listK(spk.getQy_xz());
					if(!list.contains(kh.getKhdm())) {
						return "您不符合购买"+spk.getSpmc()+"商品的要求，请谅解！";
					}
				}
				if(StringUtil.isNotEmpty(spk.getCl_xz())) {
					if(spk.getCl_xz().equals("整件") && Integer.parseInt(sl[i])%spk.getWbzsl()!=0) {
						return spk.getSpmc()+"必须是整件购买";
					}else if(spk.getCl_xz().equals("中包装") && Integer.parseInt(sl[i])%spk.getNbzsl()!=0) {
						return spk.getSpmc()+"必须按中包装的整倍数购买";
					}
				}
				if(spk.getKysl()<Integer.parseInt(sl[i])) {
					return spk.getSpmc()+"库存数量不足！";
				}
			}else {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("spdm", spdm[i]);
				map.put("spph", spph[i]);
				Long findKc =jinxqDao.findKc(map);
				if(findKc<Integer.parseInt(sl[i])) {
					return "代码为"+spdm[i]+",批号为"+spph[i]+"的商品库存数量不足！";
				}
			}
		}
		return null;
	}
	
	
	/**
	 * 首页新品上市小模块的查询
	 * @return
	 */
	public List<Spk> shouyexpss(){
		return spkDao.shouyexpss();
	}
	
}
