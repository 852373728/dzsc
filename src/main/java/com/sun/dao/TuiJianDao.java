package com.sun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.TuiJian;

public interface TuiJianDao {

	/**
	 * ����homePageTuijianCarousel=1�ֶβ�ѯ,�ò�ѯΪ��ҳ�Ƽ�Ʒ����Ŀ����ߵ��ֲ�ͼƬ��ѯ
	 * @return
	 */
	public List<TuiJian> findByhpCarosel();
	
	/**
	 * ���ݵ��������������ѯ��Ʒ
	 * @return
	 */
	public List<TuiJian> findBytwoBarName(@Param("twobarname")String twobarname);
	
	/**
	 * ����showCarousel=1�ֶβ�ѯ���Ƽ�Ʒ��ҳ����ֲ�
	 * @return
	 */
	public List<TuiJian> carousel();
	
	/**
	 * �Ƽ�ҳ���¸���Ŀ������ߵ�һ��ͼƬ��ѯ
	 * @param twobarid
	 * @return
	 */
	public TuiJian findByshow2(@Param("twobarname")String twobarname);
 }
