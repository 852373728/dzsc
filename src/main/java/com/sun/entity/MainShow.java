package com.sun.entity;

/**
 * ��ҳ���ȵ㣬�ֲ�������Ȥ����ҳ����ͼƬ�ĸ���Ŀ��
 * @author asus
 *
 */

public class MainShow {
	
	private int id;
	private String sywzdm;//��ҳλ�ô���  1=�ȵ㣬2=�ֲ���3=����Ȥ��4=����ͼƬ
	private String sywzmc;//��ҳλ������
	private String tplj;//��ƷͼƬ·��
	private String backcolor;//����ɫ
	private int xh;//��ţ�չʾ��˳��
	private Integer spkid;//��Ʒ�������id
	private Spk spk;
	private String searchName;//��̨������ѯ����ʱ�ֶ�
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSywzdm() {
		return sywzdm;
	}
	public void setSywzdm(String sywzdm) {
		this.sywzdm = sywzdm;
	}
	public String getSywzmc() {
		return sywzmc;
	}
	public void setSywzmc(String sywzmc) {
		this.sywzmc = sywzmc;
	}
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	public String getTplj() {
		return tplj;
	}
	public void setTplj(String tplj) {
		this.tplj = tplj;
	}
	public String getBackcolor() {
		return backcolor;
	}
	public void setBackcolor(String backcolor) {
		this.backcolor = backcolor;
	}
	public Integer getSpkid() {
		return spkid;
	}
	public void setSpkid(Integer spkid) {
		this.spkid = spkid;
	}
	public Spk getSpk() {
		return spk;
	}
	public void setSpk(Spk spk) {
		this.spk = spk;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	
	
}
