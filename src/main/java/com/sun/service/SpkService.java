package com.sun.service;

import java.util.List;
import java.util.Map;


import com.sun.entity.Kh;
import com.sun.entity.Spk;

public interface SpkService {


	/**
	 * �û�δ��¼ʱ��ͨ��spkID���ʵ�壬ĳЩ�ֶβ���չʾ
	 * @param id
	 * @return
	 */
	public Spk getOne(Integer id);
	
	/**
	 * �û��ѵ�¼��ͨ��spkID���ʵ�壬չʾ���ֶζ�Щ������û����
	 * @param id
	 * @return
	 */
	public Spk getOneUser(Integer id,Kh kh);
	
	/**
	 * ȫ����Ʒ�������в�ѯ
	 * @return
	 */
	public List<Spk> sale();
	
	/**
	 * ȫ����Ʒ������в�ѯ
	 * @return
	 */
	public List<Spk> click();
	
	/**
	 * �ɹ�ҳ�����Ʒ��ѯ
	 * @param map
	 * @return
	 */
	public List<Spk> findSpkList(Map<String, Object> map,boolean loggedIn,Kh kh);
	
	/**
	 * �ɹ�ҳ�����Ʒ��������ѯ
	 * @return
	 */
	public Long total(Map<String, Object> map);
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ�����Ķ��������б�
	 * @param map
	 * @return
	 */
	public List<Spk> findSplbTwo(Map<String, Object> map);
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ������һ�������б�
	 * @param map
	 * @return
	 */
	public List<Spk> findSplbOne(Map<String, Object> map);
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ�������������ң��̶���ѯ15�����ң�����������sccj��
	 * @param map
	 * @return
	 */
	public List<Spk> findSccj(Map<String, Object> map);
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ�������ͣ�ȥ���˿յ�
	 * @param map
	 * @return
	 */
	public List<Spk> findJx(Map<String, Object> map);
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ�����������ͣ�ȥ���˿յ�
	 * @param map
	 * @return
	 */
	public List<Spk> findXz(Map<String, Object> map);
	
	/**
	 * �ɹ�ҳ��չʾ����Ʒ����ҽ�����ͣ�ȥ���˿յ�
	 * @param map
	 * @return
	 */
	public List<Spk> findyl(Map<String, Object> map);
	
	/**
	 * �Ƽ�Ʒ�ָ���ҳ��ġ��Ƽ����͡�����
	 * @param map
	 * @return
	 */
	public List<Spk> findTwoBar(Map<String, Object> map);
	
	/**
	 * ������Ʒ
	 * @return
	 */
	public List<Spk> hotNew();
	
	/**
	 * ��Ʒ����ҳ�棬�ұߵ���������Ʒ��ѯ
	 * @param map
	 * @return
	 */
	public List<Spk> goodRight(Map<String, Object> map,boolean loggedIn,Kh kh);
	
	/**
	 * ���ݳ������Ʋ�����Ʒ
	 * @param SCCJ1
	 * @return
	 */
	public List<Spk> findBySCCJ1(Map<String, Object> map,boolean loggedIn,Kh kh);
	
	/**
	 * ������к��������е��޸�
	 * @param map
	 */
	public void editph(Map<String, Object> map);
	
	public Spk getOneUserBymap(Map<String, Object> map);
	
	/**
	 * ��Ʒ�Ŀ����������û��������������֤���������㲻�ܹ���
	 * @param spdm
	 * @return
	 */
	public String kysl(String spdmStrs,String sls,Kh kh,String spphs);
	
	/**
	 * ��ҳ��Ʒ����Сģ��Ĳ�ѯ
	 * @return
	 */
	public List<Spk> shouyexpss();
	
}
