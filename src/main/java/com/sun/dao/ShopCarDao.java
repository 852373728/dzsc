package com.sun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Jinxq;
import com.sun.entity.ShopCar;

public interface ShopCarDao {

	/**
	 * ��ӹ��ﳵ��Ʒ
	 * @param shopCar
	 */
	public void add(ShopCar shopCar);
	
	/**
	 * ���ﳵ��ѯ
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
	 * ͨ��idɾ��
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * ͨ����������ɾ��
	 * @param map
	 */
	public void deleteByMap(Map<String, Object> map);
	
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
	public List<Jinxq> cxList(@Param("username")String username);
	
}
