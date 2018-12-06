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
	 * �û�δ��¼ʱ��ͨ��spkID���ʵ�壬ĳЩ�ֶβ���չʾ
	 * @param id
	 * @return
	 */
	public Spk getOne(Integer id) {
		return spkDao.getOne(id);
	}
	
	/**
	 * �û��ѵ�¼��ͨ��spkID���ʵ�壬չʾ���ֶζ�Щ������û����
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
	 * ȫ����Ʒ�������в�ѯ,HomePageController.home
	 * @return
	 */
	public List<Spk> sale() {
		return spkDao.sale();
	}

	/**
	 * ȫ����Ʒ������в�ѯ,HomePageController.home
	 * @return
	 */
	public List<Spk> click() {
		return spkDao.click();
	}

	/**
	 * �ɹ�ҳ�����Ʒ��ѯ HomePageController.java �Ƽ�Ʒ�ָ���ҳ�棬�ר������ҳ��
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
					huoDong.setHuoDongContent("��½�ɼ�");
					spk.setHuoDong(huoDong);
				}
			}
			return spkList;
		}
	}

	/**
	 * �ɹ�ҳ�����Ʒ��������ѯ
	 * @return
	 */
	public Long total(Map<String, Object> map) {
		return spkDao.total(map);
	}

	/**
	 * �ɹ�ҳ��չʾ����Ʒ�����Ķ��������б�
	 * @param map
	 * @return
	 */
	public List<Spk> findSplbTwo(Map<String, Object> map) {
		return spkDao.findSplbTwo(map);
	}
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ������һ�������б�
	 * @param map
	 * @return
	 */
	public List<Spk> findSplbOne(Map<String, Object> map){
		return spkDao.findSplbOne(map);
	}
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ�������������ң��̶���ѯ15�����ң�����������sccj��
	 * @param map
	 * @return
	 */
	public List<Spk> findSccj(Map<String, Object> map){
		return spkDao.findSccj(map);
	}
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ�������ͣ�ȥ���˿յ�
	 * @param map
	 * @return
	 */
	public List<Spk> findJx(Map<String, Object> map){
		return spkDao.findJx(map);
	}

	/**
	 * �ɹ�ҳ��չʾ����Ʒ�����������ͣ�ȥ���˿յ�
	 * @param map
	 * @return
	 */
	public List<Spk> findXz(Map<String, Object> map){
		return spkDao.findXz(map);
	}
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ����ҽ�����ͣ�ȥ���˿յ�
	 * @param map
	 * @return
	 */
	public List<Spk> findyl(Map<String, Object> map){
		return spkDao.findyl(map);
	}
	
	/**
	 * �Ƽ�Ʒ�ָ���ҳ��ġ��Ƽ����͡�����
	 * @param map
	 * @return
	 */
	public List<Spk> findTwoBar(Map<String, Object> map){
		return spkDao.findTwoBar(map);
	}

	/**
	 * ������Ʒ
	 * @return
	 */
	public List<Spk> hotNew(){
		return spkDao.hotNew();
	}
	
	/**
	 * ��Ʒ����ҳ�棬�ұߵ���������Ʒ��ѯ
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
	 * ���ݳ������Ʋ�����Ʒ
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
	 * ������к��������е��޸�
	 * @param map
	 */
	public void editph(Map<String, Object> map) {
		spkDao.editph(map);
	}
	
	public Spk getOneUserBymap(Map<String, Object> map) {
		return spkDao.getOneUserBymap(map);
	}
	
	/**
	 * ��Ʒ�Ŀ����������û��������������֤���������㲻�ܹ���
	 * @param spdm
	 * @return
	 */
	public String kysl(String spdmStrs,String sls,Kh kh,String spphs) {
		String[] spdm = spdmStrs.split(",");
		String[] sl = sls.split(",");
		String[] spph = spphs.split(",");
		if(spdm.length!=sl.length || spdm.length!=spph.length) {
			return "��������";
		}
		for(int i=0;i<spdm.length;i++) {
			if(Integer.parseInt(sl[i])<=0) {
				return "������������Ϊ0��";
			}
			if(spph[i].equals("sun")) {
				Spk spk = spkDao.kysl(spdm[i]);
				if(spk==null) {
					return "��Ʒ������";
				}
				if(spk.getXsjg()<=0.0) {
					return spk.getSpmc()+"�۸�������ʱ�޷�����";
				}
				if(StringUtil.isNotEmpty(spk.getQy_xz())) {
					List<String> list = useKhDao.listK(spk.getQy_xz());
					if(!list.contains(kh.getKhdm())) {
						return "�������Ϲ���"+spk.getSpmc()+"��Ʒ��Ҫ�����½⣡";
					}
				}
				if(StringUtil.isNotEmpty(spk.getCl_xz())) {
					if(spk.getCl_xz().equals("����") && Integer.parseInt(sl[i])%spk.getWbzsl()!=0) {
						return spk.getSpmc()+"��������������";
					}else if(spk.getCl_xz().equals("�а�װ") && Integer.parseInt(sl[i])%spk.getNbzsl()!=0) {
						return spk.getSpmc()+"���밴�а�װ������������";
					}
				}
				if(spk.getKysl()<Integer.parseInt(sl[i])) {
					return spk.getSpmc()+"����������㣡";
				}
			}else {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("spdm", spdm[i]);
				map.put("spph", spph[i]);
				Long findKc =jinxqDao.findKc(map);
				if(findKc<Integer.parseInt(sl[i])) {
					return "����Ϊ"+spdm[i]+",����Ϊ"+spph[i]+"����Ʒ����������㣡";
				}
			}
		}
		return null;
	}
	
	
	/**
	 * ��ҳ��Ʒ����Сģ��Ĳ�ѯ
	 * @return
	 */
	public List<Spk> shouyexpss(){
		return spkDao.shouyexpss();
	}
	
}
