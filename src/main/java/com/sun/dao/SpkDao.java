package com.sun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sun.entity.Spk;

public interface SpkDao {
	
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
	public Spk getOneUser(Integer id);
	
	/**
	 * �û��ѵ�¼��ͨ��spkĳЩ�ֶλ��ʵ�壬չʾ���ֶζ�Щ������û����
	 * @param id
	 * @return
	 */
	public Spk getOneUserBymap(Map<String, Object> map);
	
	
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
	 * ���ݶ�������ѯ��������
	 * @return
	 */
	public List<Spk> hotSale(Map<String, Object> map);
	
	/**
	 * ���ݶ�������ѯ��������,�û���¼��
	 * @return
	 */
	public List<Spk> hotSaleUser(Map<String, Object> map);
	
	/**
	 * �ɹ�ҳ�����Ʒ��ѯ
	 * @param map
	 * @return
	 */
	public List<Spk> findSpkList(Map<String, Object> map);
	
	/**
	 * �ɹ�ҳ�����Ʒ��ѯ,�û���¼��
	 * @param map
	 * @return
	 */
	public List<Spk> findSpkListUser(Map<String, Object> map);
	
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
	 * �Ƽ�Ʒ�ָ���ҳ��ġ��Ƽ����͡������ͻר������ҳ��ġ��������͡�����
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
	 * ���ݳ������Ʋ�����Ʒ
	 * @param SCCJ1
	 * @return
	 */
	public List<Spk> findBySCCJ1(Map<String, Object> map);
	
	/**
	 * ���ݳ������Ʋ�����Ʒ���û���¼��
	 * @param SCCJ1
	 * @return
	 */
	public List<Spk> findBySCCJ1User(Map<String, Object> map);
	
	
	public Long findBySCCJ1Count(Map<String, Object> map);
	/**
	 * ��Ʒ����ҳ�棬�ұߵ���������Ʒ��ѯ
	 * @param map
	 * @return
	 */
	public List<Spk> goodRight(Map<String, Object> map);
	
	/**
	 * ��Ʒ����ҳ�棬�ұߵ���������Ʒ��ѯ,�û���¼��
	 * @param map
	 * @return
	 */
	public List<Spk> goodRightUser(Map<String, Object> map);

	/**
	 * ������к��������е��޸�
	 * @param map
	 */
	public void editph(Map<String, Object> map);
	
	/**
	 * ��Ʒ�Ŀ����������û��������������֤���������㲻�ܹ���
	 * @param spdm
	 * @return
	 */
	public Spk kysl(@Param("spdm")String spdm);
	
	/**
	 * ����û����Żݼ۸�
	 * @param map
	 * @return
	 */
	public Float discount(Map<String, Object> map);
	
	/**
	 * ��ҳ��Ʒ����Сģ��Ĳ�ѯ
	 * @return
	 */
	public List<Spk> shouyexpss();
	
}
