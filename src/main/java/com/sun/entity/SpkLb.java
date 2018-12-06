package com.sun.entity;

import java.util.List;

public class SpkLb {

	  private int id;
      private String lbdm;
      private String lbmc;
      private String lbparent;
      private int xh;
      private String show;//1=首页的展示
      private int cjbz;
      private float KCSL;
      private float KCJE;
      private float KHJE;
      private float xssl;
      private float xsje;
      private float cbje;
      private float ml;
      private float mll;
      private float khml;
      private int qcsl;
      private int qcje;
      private int jhje;
      private int jhsl;
      private int sysl;
      private int syje;
      private int jysl;
      private int jyje;
      private int zid;
      private int mxid;
     
      
      private List<SpkLb> spklbList;
      private List<MainTypeShow> mainTypeShowList1;//用来装首页商品等栏目下二级栏目下的商品
      private List<MainTypeShow> mainTypeShowList2;//用来装首页商品等栏目下左边第一张图片
      private List<MainTypeShow> mainTypeShowList3;//用来装首页商品等栏目下大家都在找
      private List<Sccj> sccjList;
      private List<Spk> spkList;
      private SpkLb spkLb;
      
      
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLbdm() {
		return lbdm;
	}
	public void setLbdm(String lbdm) {
		this.lbdm = lbdm;
	}
	public String getLbmc() {
		return lbmc;
	}
	public void setLbmc(String lbmc) {
		this.lbmc = lbmc;
	}
	public String getLbparent() {
		return lbparent;
	}
	public void setLbparent(String lbparent) {
		this.lbparent = lbparent;
	}
	public int getCjbz() {
		return cjbz;
	}
	public void setCjbz(int cjbz) {
		this.cjbz = cjbz;
	}
	public float getKCSL() {
		return KCSL;
	}
	public void setKCSL(float kCSL) {
		KCSL = kCSL;
	}
	public float getKCJE() {
		return KCJE;
	}
	public void setKCJE(float kCJE) {
		KCJE = kCJE;
	}
	public float getKHJE() {
		return KHJE;
	}
	public void setKHJE(float kHJE) {
		KHJE = kHJE;
	}
	public float getXssl() {
		return xssl;
	}
	public void setXssl(float xssl) {
		this.xssl = xssl;
	}
	public float getXsje() {
		return xsje;
	}
	public void setXsje(float xsje) {
		this.xsje = xsje;
	}
	public float getCbje() {
		return cbje;
	}
	public void setCbje(float cbje) {
		this.cbje = cbje;
	}
	public float getMl() {
		return ml;
	}
	public void setMl(float ml) {
		this.ml = ml;
	}
	public float getMll() {
		return mll;
	}
	public void setMll(float mll) {
		this.mll = mll;
	}
	public float getKhml() {
		return khml;
	}
	public void setKhml(float khml) {
		this.khml = khml;
	}
	public int getQcsl() {
		return qcsl;
	}
	public void setQcsl(int qcsl) {
		this.qcsl = qcsl;
	}
	public int getQcje() {
		return qcje;
	}
	public void setQcje(int qcje) {
		this.qcje = qcje;
	}
	public int getJhje() {
		return jhje;
	}
	public void setJhje(int jhje) {
		this.jhje = jhje;
	}
	public int getJhsl() {
		return jhsl;
	}
	public void setJhsl(int jhsl) {
		this.jhsl = jhsl;
	}
	public int getSysl() {
		return sysl;
	}
	public void setSysl(int sysl) {
		this.sysl = sysl;
	}
	public int getSyje() {
		return syje;
	}
	public void setSyje(int syje) {
		this.syje = syje;
	}
	public int getJysl() {
		return jysl;
	}
	public void setJysl(int jysl) {
		this.jysl = jysl;
	}
	public int getJyje() {
		return jyje;
	}
	public void setJyje(int jyje) {
		this.jyje = jyje;
	}
	public int getZid() {
		return zid;
	}
	public void setZid(int zid) {
		this.zid = zid;
	}
	public int getMxid() {
		return mxid;
	}
	public void setMxid(int mxid) {
		this.mxid = mxid;
	}
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public List<SpkLb> getSpklbList() {
		return spklbList;
	}
	public void setSpklbList(List<SpkLb> spklbList) {
		this.spklbList = spklbList;
	}
	public List<MainTypeShow> getMainTypeShowList1() {
		return mainTypeShowList1;
	}
	public void setMainTypeShowList1(List<MainTypeShow> mainTypeShowList1) {
		this.mainTypeShowList1 = mainTypeShowList1;
	}
	public List<MainTypeShow> getMainTypeShowList2() {
		return mainTypeShowList2;
	}
	public void setMainTypeShowList2(List<MainTypeShow> mainTypeShowList2) {
		this.mainTypeShowList2 = mainTypeShowList2;
	}
	public List<MainTypeShow> getMainTypeShowList3() {
		return mainTypeShowList3;
	}
	public void setMainTypeShowList3(List<MainTypeShow> mainTypeShowList3) {
		this.mainTypeShowList3 = mainTypeShowList3;
	}
	public List<Sccj> getSccjList() {
		return sccjList;
	}
	public void setSccjList(List<Sccj> sccjList) {
		this.sccjList = sccjList;
	}
	public List<Spk> getSpkList() {
		return spkList;
	}
	public void setSpkList(List<Spk> spkList) {
		this.spkList = spkList;
	}
	public SpkLb getSpkLb() {
		return spkLb;
	}
	public void setSpkLb(SpkLb spkLb) {
		this.spkLb = spkLb;
	}
	
	
      
	
}
