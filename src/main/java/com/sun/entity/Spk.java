package com.sun.entity;

import com.sun.util.StringUtil;

public class Spk {
	
	  private int id;
      private String spdm;//商品代码
      private String zjm;//助记码
      private String spmc;//商品名称
      private String spgg;//规格
      private String SCCJ1;//生产企业
      private String sccj1dm;//生产企业代码
      private int wbzsl;//装箱
      private int nbzsl;//中包装
      private String dw;//单位
      private String sccj;
      private float shl;
      private String jzrq;
      private String splb;
      private String splbdm;
      private String web_splb;//分类名称
      private String web_splbdm;//分类代码
      private String txm;
      private String pzwh;//批准文号
      private float splsdj;//零售价
      private float sppfdj;
      private String jxdm;//剂型代码
      private String jxmc;//剂型
      private String zlbz;//质量标准
      private String USEDIN;
      private String xingz;//性状
      private String yxq;//有效期
      private String store;//贮藏要求
      private String baoz;//包装
      private String SPM;
      private String YWM;
      private String khdm;//客户代码
      private String khmc;//客户名称
      private String khxz;//区域限制
      private String qy_xz;//企业性质
      private String cl_xz;//拆零限制
      private String cx_xz;//促销
      private String yxrq;
      private float j_zj;//整件价格
      private float j_xj;//拆零价格
      private String Lastupdate_ry;
      private String Lastupdate_sj;//日期
      private String sj_xz;//是否上架
      private String Hasupload;//回写字段
      private String pict;//图片
      private String xzmc;//性质
      private String ylmc;//医药类型
      private String kx_xz;//控销
      private String xj_xz;//新品
      private float j_cxj;//促销价
      private String st_lb;//仓储分类,在途，在库
      private float xsjg;//销售价格
      private float lsdj;//建议零售价
      private float cb4;//医保支付价
      private int xlph;//销量排行
      private int djph;//点击排行
      private String searchName;//后台用来搜索的临时字段
      private HuoDong huoDong;
      private int kysl;
      private String discount;//价格优惠标志
      private String pict_sm;//说明书图片
      private String spph;
      private float cxdj;//促销价格
  	  
	public float getCxdj() {
		return cxdj;
	}
	public void setCxdj(float cxdj) {
		this.cxdj = cxdj;
	}
	public String getSpph() {
		return spph;
	}
	public void setSpph(String spph) {
		this.spph = spph;
	}
	public String getPict_sm() {
		return pict_sm;
	}
	public void setPict_sm(String pict_sm) {
		this.pict_sm = pict_sm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpdm() {
		return spdm;
	}
	public void setSpdm(String spdm) {
		this.spdm = spdm;
	}
	public String getZjm() {
		return zjm;
	}
	public void setZjm(String zjm) {
		this.zjm = zjm;
	}
	public String getSpmc() {
		return spmc;
	}
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	public String getSpgg() {
		return spgg;
	}
	public void setSpgg(String spgg) {
		this.spgg = spgg;
	}
	public String getSCCJ1() {
		return SCCJ1;
	}
	public void setSCCJ1(String sCCJ1) {
		SCCJ1 = sCCJ1;
	}
	public String getSccj1dm() {
		return sccj1dm;
	}
	public void setSccj1dm(String sccj1dm) {
		this.sccj1dm = sccj1dm;
	}
	public int getWbzsl() {
		return wbzsl;
	}
	public void setWbzsl(int wbzsl) {
		this.wbzsl = wbzsl;
	}
	public int getNbzsl() {
		return nbzsl;
	}
	public void setNbzsl(int nbzsl) {
		this.nbzsl = nbzsl;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getSccj() {
		return sccj;
	}
	public void setSccj(String sccj) {
		this.sccj = sccj;
	}
	public float getShl() {
		return shl;
	}
	public void setShl(float shl) {
		this.shl = shl;
	}
	
	public String getSplb() {
		return splb;
	}
	public void setSplb(String splb) {
		this.splb = splb;
	}
	public String getSplbdm() {
		return splbdm;
	}
	public void setSplbdm(String splbdm) {
		this.splbdm = splbdm;
	}
	public String getWeb_splb() {
		return web_splb;
	}
	public void setWeb_splb(String web_splb) {
		this.web_splb = web_splb;
	}
	public String getWeb_splbdm() {
		return web_splbdm;
	}
	public void setWeb_splbdm(String web_splbdm) {
		this.web_splbdm = web_splbdm;
	}
	public String getTxm() {
		return txm;
	}
	public void setTxm(String txm) {
		this.txm = txm;
	}
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}
	public float getSplsdj() {
		return splsdj;
	}
	public void setSplsdj(float splsdj) {
		this.splsdj = splsdj;
	}
	public float getSppfdj() {
		return sppfdj;
	}
	public void setSppfdj(float sppfdj) {
		this.sppfdj = sppfdj;
	}
	public String getJxdm() {
		return jxdm;
	}
	public void setJxdm(String jxdm) {
		this.jxdm = jxdm;
	}
	public String getJxmc() {
		return jxmc;
	}
	public void setJxmc(String jxmc) {
		this.jxmc = jxmc;
	}
	public String getZlbz() {
		return zlbz;
	}
	public void setZlbz(String zlbz) {
		this.zlbz = zlbz;
	}
	public String getUSEDIN() {
		return USEDIN;
	}
	public void setUSEDIN(String uSEDIN) {
		USEDIN = uSEDIN;
	}
	public String getXingz() {
		return xingz;
	}
	public void setXingz(String xingz) {
		this.xingz = xingz;
	}
	public String getYxq() {
		return yxq;
	}
	public void setYxq(String yxq) {
		this.yxq = yxq;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getBaoz() {
		return baoz;
	}
	public void setBaoz(String baoz) {
		this.baoz = baoz;
	}
	public String getSPM() {
		return SPM;
	}
	public void setSPM(String sPM) {
		SPM = sPM;
	}
	public String getYWM() {
		return YWM;
	}
	public void setYWM(String yWM) {
		YWM = yWM;
	}
	public String getKhdm() {
		return khdm;
	}
	public void setKhdm(String khdm) {
		this.khdm = khdm;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getKhxz() {
		return khxz;
	}
	public void setKhxz(String khxz) {
		this.khxz = khxz;
	}
	public String getQy_xz() {
		return qy_xz;
	}
	public void setQy_xz(String qy_xz) {
		this.qy_xz = qy_xz;
	}
	public String getCl_xz() {
		return cl_xz;
	}
	public void setCl_xz(String cl_xz) {
		this.cl_xz = cl_xz;
	}
	public String getCx_xz() {
		return cx_xz;
	}
	public void setCx_xz(String cx_xz) {
		this.cx_xz = cx_xz;
	}
	public float getJ_zj() {
		return j_zj;
	}
	public void setJ_zj(float j_zj) {
		this.j_zj = j_zj;
	}
	public float getJ_xj() {
		return j_xj;
	}
	public void setJ_xj(float j_xj) {
		this.j_xj = j_xj;
	}
	public String getLastupdate_ry() {
		return Lastupdate_ry;
	}
	public void setLastupdate_ry(String lastupdate_ry) {
		Lastupdate_ry = lastupdate_ry;
	}
	public String getJzrq() {
		return jzrq;
	}
	public void setJzrq(String jzrq) {
		this.jzrq = jzrq;
	}
	public String getYxrq() {
		return yxrq;
	}
	public void setYxrq(String yxrq) {
		this.yxrq = yxrq;
	}
	public String getLastupdate_sj() {
		return Lastupdate_sj;
	}
	public void setLastupdate_sj(String lastupdate_sj) {
		Lastupdate_sj = lastupdate_sj;
	}
	public String getSj_xz() {
		return sj_xz;
	}
	public void setSj_xz(String sj_xz) {
		this.sj_xz = sj_xz;
	}
	public String getHasupload() {
		return Hasupload;
	}
	public void setHasupload(String hasupload) {
		Hasupload = hasupload;
	}
	public String getPict() {
		return pict;
	}
	public void setPict(String pict) {
		this.pict = pict;
	}
	public String getXzmc() {
		return xzmc;
	}
	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
	}
	public String getYlmc() {
		if(StringUtil.isNotEmpty(ylmc)) {
			if(ylmc.substring(0, 1).equals("甲")) {
				return "甲";
			}else if(ylmc.substring(0, 1).equals("乙")) {
				return "乙";
			}else {
				return "";
			}
		}else {
			return "";
		}
	}
	public void setYlmc(String ylmc) {
		this.ylmc = ylmc;
	}
	public String getKx_xz() {
		return kx_xz;
	}
	public void setKx_xz(String kx_xz) {
		this.kx_xz = kx_xz;
	}
	public String getXj_xz() {
		return xj_xz;
	}
	public void setXj_xz(String xj_xz) {
		this.xj_xz = xj_xz;
	}
	public float getJ_cxj() {
		return j_cxj;
	}
	public void setJ_cxj(float j_cxj) {
		this.j_cxj = j_cxj;
	}
	public String getSt_lb() {
		return st_lb;
	}
	public void setSt_lb(String st_lb) {
		this.st_lb = st_lb;
	}
	public float getLsdj() {
		return lsdj;
	}
	public void setLsdj(float lsdj) {
		this.lsdj = lsdj;
	}
	public float getCb4() {
		return cb4;
	}
	public void setCb4(float cb4) {
		this.cb4 = cb4;
	}
	public float getXsjg() {
		return xsjg;
	}
	public void setXsjg(float xsjg) {
		this.xsjg = xsjg;
	}
	public int getXlph() {
		return xlph;
	}
	public void setXlph(int xlph) {
		this.xlph = xlph;
	}
	public int getDjph() {
		return djph;
	}
	public void setDjph(int djph) {
		this.djph = djph;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public HuoDong getHuoDong() {
		return huoDong;
	}
	public void setHuoDong(HuoDong huoDong) {
		this.huoDong = huoDong;
	}
	public int getKysl() {
		return kysl;
	}
	public void setKysl(int kysl) {
		this.kysl = kysl;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	
      
	
}
