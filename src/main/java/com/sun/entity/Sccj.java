package com.sun.entity;

import java.util.List;

public class Sccj {

	private int id;
	private String cjmc;
	private String cjdm;
	private String show;//1=���ڿɹ�ҳ�泧����������ʱ,�Ƽ�ҳ����࣬�ר������ҳ��
	private int xh;//����
	private String splbDm;//������ҳҩƷ����Ŀ�³���չʾ
	private String cjjj;//���Ҽ��
	private String tplj;//ͼƬ·��
	private String tuijianShow;//1=�Ƽ�Ʒ��ҳ�泧����ʾ
	private int tuijianxh;//�Ƽ�Ʒ��ҳ�泧������
	private String pinpaiShow;//1=Ʒ��ר������ĵ���ʾ
	private int pinpaixh;//Ʒ��ר�����������
	private String spdmList;//Ʒ��ר��Ҫչʾ����Ʒ 
	
	
	private List<Spk> spkList;
	private Long spkTotal;//ÿ�����Һ��ж�����Ʒ��ͨ��sql����ѯ��
	private SpkLb spkLb;
	
	
	public String getSpdmList() {
		return spdmList;
	}
	public void setSpdmList(String spdmList) {
		this.spdmList = spdmList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCjmc() {
		return cjmc;
	}
	public void setCjmc(String cjmc) {
		this.cjmc = cjmc;
	}
	public String getCjdm() {
		return cjdm;
	}
	public void setCjdm(String cjdm) {
		this.cjdm = cjdm;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	
	public String getSplbDm() {
		return splbDm;
	}
	public void setSplbDm(String splbDm) {
		this.splbDm = splbDm;
	}
	public String getCjjj() {
		return cjjj;
	}
	public void setCjjj(String cjjj) {
		this.cjjj = cjjj;
	}
	public String getTplj() {
		return tplj;
	}
	public void setTplj(String tplj) {
		this.tplj = tplj;
	}
	public String getTuijianShow() {
		return tuijianShow;
	}
	public void setTuijianShow(String tuijianShow) {
		this.tuijianShow = tuijianShow;
	}
	public int getTuijianxh() {
		return tuijianxh;
	}
	public void setTuijianxh(int tuijianxh) {
		this.tuijianxh = tuijianxh;
	}
	public String getPinpaiShow() {
		return pinpaiShow;
	}
	public void setPinpaiShow(String pinpaiShow) {
		this.pinpaiShow = pinpaiShow;
	}
	public int getPinpaixh() {
		return pinpaixh;
	}
	public void setPinpaixh(int pinpaixh) {
		this.pinpaixh = pinpaixh;
	}
	public List<Spk> getSpkList() {
		return spkList;
	}
	public void setSpkList(List<Spk> spkList) {
		this.spkList = spkList;
	}
	public Long getSpkTotal() {
		return spkTotal;
	}
	public void setSpkTotal(Long spkTotal) {
		this.spkTotal = spkTotal;
	}
	public SpkLb getSpkLb() {
		return spkLb;
	}
	public void setSpkLb(SpkLb spkLb) {
		this.spkLb = spkLb;
	}
	
	
}
