package com.sun.dao;

import java.util.List;


import com.sun.entity.HuoDong;

public interface HuoDongDao {

	/**
	 * ����homePageHuoDongCarousel=1�ֶβ�ѯ,�ò�ѯΪ��ҳ���»��Ŀ����ߵ��ֲ�ͼƬ��ѯ
	 * @return
	 */
	public List<HuoDong> findByhpCarosel();
	
	/*
	 * ���ݵ��������������ѯ�����Ʒ
	 */
	public List<HuoDong> findByTwoBarId(Integer twobarid);
	
	/**
	 * �ҳ��Ļ��Ʒ��ѯ
	 * @param threebarid
	 * @return
	 */
	public List<HuoDong> hdyList(Integer twobarid);
	
	/**
	 * ������Ʒ��id��ѯ��һϵ�е�������ѯ����Ʒ�Ƿ����ڲμӻ
	 * @param spkid
	 * @return
	 */
	public HuoDong getBySpkId(Integer spkid);
 }
