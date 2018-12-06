package com.sun.service;

import java.util.List;
import java.util.Map;


import com.sun.entity.Jinxq;
import com.sun.entity.Kh;
import com.sun.entity.ShopCar;

public interface ShopCarService {

	/**
	 * ��ӹ��ﳵ��Ʒ
	 * @param shopCar
	 */
	public void add(ShopCar shopCar);
	
	/**
	 * ���ﳵ��ѯ����������Ʒ
	 * @param map
	 * @return
	 */
	public List<ShopCar> list(Map<String, Object> map);
	
	/**
	 * ���ﳵ����
	 * @param map
	 * @return
	 */
	public Long Count(Map<String, Object> map);
	
	/**
	 * �޸Ĺ��ﳵ
	 * @param shopCar
	 */
	public void update(ShopCar shopCar);
	
	/**
	 * ���ﳵ��ѯ��������Ʒ
	 * @param map
	 * @return
	 */
	public List<ShopCar> list(Map<String, Object> map,boolean hasSpk,Kh kh);
	
	/**
	 * ͨ��idɾ��
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * �����ﳵ��Ӵ�����Ʒ
	 * @param shopCar
	 */
	public void addCx(ShopCar shopCar);
	
	/**
	 * �жϹ��ﳵ�Ƿ����иô�����Ʒ��ֻ��Դ�����Ʒ
	 * @param shopCar
	 * @return
	 */
	public Long judgeExit(ShopCar shopCar);
	
	/**
	 * ���ﳵ���иô�����Ʒ���ڴ˻����ϼ�����
	 * @param shopCar
	 */
	public void editExit(ShopCar shopCar);
	
	/**
	 * ���ﳵ������Ʒ��ѯ
	 * @param username
	 * @return
	 */
	public List<Jinxq> cxList(String username);
}
