package com.sun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Sccj;

public interface SccjDao {

	/**
	 * ������ҳҩƷ����Ŀ�µĳ�����Ϣ��ѯ
	 * @return
	 */
	public List<Sccj> findBysplbdm(@Param("splbDm")String splbDm);
	
	/**
	 * �Ƽ�ҳ��ĳ�����ʾ,�����ֶ�tuijianShow=1��ѯ
	 * @return
	 */
	public List<Sccj> tuiJian();
	
	/**
	 * Ʒ��ר�������12��������ʾ�������ֶ�pinpaiShow=1��ѯ
	 * @return
	 */
	public List<Sccj> pinpaiShow();
	
	/**
	 * Ʒ��ר�����ҷ�ҳ��ѯ
	 * @param map
	 * @return
	 */
	public List<Sccj> fenye(Map<String, Object> map);
	
	/**
	 * Ʒ��ר����������������ʾ
	 * @param map
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	/**
	 * ���ݳ������ƻ�øó���ʵ��
	 * @param cjmc
	 * @return
	 */
	public Sccj getSccj(@Param("cjmc")String cjmc);
}
