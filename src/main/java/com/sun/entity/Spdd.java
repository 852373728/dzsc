package com.sun.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class Spdd {

	private int id;
	private String ddbh;//�������
	private double zongjia;//�ܼ۸�
	private Date zdrq;//�Ƶ�����
	@SuppressWarnings("unused")
	private String zdrqStr;//�Ƶ������ַ���
	private String formatZdrq;//��ʽ������Ƶ�����
	private String username;//�ͻ��ĵ�¼�˺�
	private String dwmc;
	private String lxr;
	private String lxdh;//��ϵ�绰
	private String adress;//��ϸ��ַ
	private String zt;//1:�ȴ�������2���ѷ�����3�����ѵ���û���ǩ��
	private String ywybh;//ҵ��Ա���
	private String ywyxm;//ҵ��Ա����
	private String khdm;//�ͻ�����
	
	
	private List<SpddMx> spddMxList;
	
	public Spdd() {
		super();
	}
	
	
	public Spdd(String ddbh, double zongjia, Date zdrq, String username, String dwmc, String lxr,String lxdh,String adress, String zt,String ywybh,String ywyxm,String khdm) {
		super();
		this.ddbh = ddbh;
		this.zongjia = zongjia;
		this.zdrq = zdrq;
		this.username = username;
		this.dwmc = dwmc;
		this.lxr = lxr;
		this.lxdh = lxdh;
		this.adress = adress;
		this.zt = zt;
		this.ywybh = ywybh;
		this.ywyxm = ywyxm;
		this.khdm = khdm;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDdbh() {
		return ddbh;
	}
	public void setDdbh(String ddbh) {
		this.ddbh = ddbh;
	}
	public double getZongjia() {
		return zongjia;
	}
	public void setZongjia(double zongjia) {
		this.zongjia = zongjia;
	}
	public Date getZdrq() {
		return zdrq;
	}
	public void setZdrq(Date zdrq) {
		this.zdrq = zdrq;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public List<SpddMx> getSpddMxList() {
		return spddMxList;
	}
	public void setSpddMxList(List<SpddMx> spddMxList) {
		this.spddMxList = spddMxList;
	}
	public String getFormatZdrq() {
		return formatZdrq;
	}
	public void setFormatZdrq(String formatZdrq) {
		this.formatZdrq = formatZdrq;
	}
	public String getYwybh() {
		return ywybh;
	}
	public void setYwybh(String ywybh) {
		this.ywybh = ywybh;
	}
	public String getYwyxm() {
		return ywyxm;
	}
	public void setYwyxm(String ywyxm) {
		this.ywyxm = ywyxm;
	}
	public String getKhdm() {
		return khdm;
	}
	public void setKhdm(String khdm) {
		this.khdm = khdm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getZdrqStr() {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(zdrq);
	}
	public void setZdrqStr(String zdrqStr) {
		this.zdrqStr = zdrqStr;
	}
	
	
}
