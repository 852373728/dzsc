package com.sun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.HuoDongDao;
import com.sun.dao.ShopCarDao;
import com.sun.dao.SpkDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.Jinxq;
import com.sun.entity.Kh;
import com.sun.entity.ShopCar;
import com.sun.entity.Spk;
import com.sun.service.ShopCarService;
import com.sun.util.StringUtil;

@Service("shopCarService")
public class ShopCarServiceImpl implements ShopCarService{

	@Resource
	private ShopCarDao shopCarDao;
	@Resource
	private SpkDao spkDao;
	@Resource
	private HuoDongDao huoDongDao;
	@Resource
	private UseKhDao useKhDao;
	
	/**
	 * ��ӹ��ﳵ��Ʒ
	 * @param shopCar
	 */
	public void add(ShopCar shopCar) {
		shopCarDao.add(shopCar);
	}
	
	/**
	 * ���ﳵ��ѯ,��������Ʒ
	 * @param map
	 * @return
	 */
	public List<ShopCar> list(Map<String, Object> map){
		return shopCarDao.list(map);
	}
	
	
	/**
	 * ���ﳵ����
	 * @param map
	 * @return
	 */
	public Long Count(Map<String, Object> map) {
		return shopCarDao.Count(map);
	}
	
	/**
	 * �޸Ĺ��ﳵ
	 * @param shopCar
	 */
	public void update(ShopCar shopCar) {
		shopCarDao.update(shopCar);
	}
	
	/**
	 * ���ﳵ��ѯ��������Ʒ
	 * @param map
	 * @return
	 */
	public List<ShopCar> list(Map<String, Object> map,boolean hasSpk,Kh kh){
		List<ShopCar> shopCarList = shopCarDao.list(map);
		Map<String, Object> map1=new HashMap<String, Object>();
		Map<String, Object> discountMap=new HashMap<String, Object>();
		for (ShopCar shopCar : shopCarList) {
			map1.put("spdm", shopCar.getSpdm());
			Spk spk = spkDao.getOneUserBymap(map1);
			if(spk!=null) {
				discountMap.put("spdm", spk.getSpdm());
				discountMap.put("khdm", kh.getKhdm());
				Float discount = spkDao.discount(discountMap);
				if(discount!=null && discount>0) {
					spk.setXsjg(discount);
					spk.setDiscount("1");
				}
				if(StringUtil.isNotEmpty(spk.getQy_xz())) {
					List<String> list = useKhDao.listK(spk.getQy_xz());
					if(!list.contains(kh.getKhdm())) {
						spk.setXsjg(-1);
						spk.setJ_xj(-1);
						spk.setJ_zj(-1);
						spk.setKysl(-1);
					}
				}
				spk.setHuoDong(huoDongDao.getBySpkId(spk.getId()));
			}
			shopCar.setSpk(spk);
		}
		return shopCarList;
	}
	
	/**
	 * ͨ��idɾ��
	 * @param id
	 */
	public void delete(Integer id) {
		shopCarDao.delete(id);
	}
	
	public void addCx(ShopCar shopCar) {
		shopCarDao.addCx(shopCar);
	}
	
	/**
	 * �жϹ��ﳵ�Ƿ����иô�����Ʒ��ֻ��Դ�����Ʒ
	 * @param shopCar
	 * @return
	 */
	public Long judgeExit(ShopCar shopCar) {
		return shopCarDao.judgeExit(shopCar);
	}
	
	/**
	 * ���ﳵ���иô�����Ʒ���ڴ˻����ϼ�����
	 * @param shopCar
	 */
	public void editExit(ShopCar shopCar) {
		shopCarDao.editExit(shopCar);
	}

	public List<Jinxq> cxList(String username) {
		return shopCarDao.cxList(username);
	}
	
}
