package com.sun.entity;

import com.sun.util.StringUtil;

public class Spk {
	
	  private int id;
      private String spdm;//��Ʒ����
      private String zjm;//������
      private String spmc;//��Ʒ����
      private String spgg;//���
      private String SCCJ1;//������ҵ
      private String sccj1dm;//������ҵ����
      private int wbzsl;//װ��
      private int nbzsl;//�а�װ
      private String dw;//��λ
      private String sccj;
      private float shl;
      private String jzrq;
      private String splb;
      private String splbdm;
      private String web_splb;//��������
      private String web_splbdm;//�������
      private String txm;
      private String pzwh;//��׼�ĺ�
      private float splsdj;//���ۼ�
      private float sppfdj;
      private String jxdm;//���ʹ���
      private String jxmc;//����
      private String zlbz;//������׼
      private String USEDIN;
      private String xingz;//��״
      private String yxq;//��Ч��
      private String store;//����Ҫ��
      private String baoz;//��װ
      private String SPM;
      private String YWM;
      private String khdm;//�ͻ�����
      private String khmc;//�ͻ�����
      private String khxz;//��������
      private String qy_xz;//��ҵ����
      private String cl_xz;//��������
      private String cx_xz;//����
      private String yxrq;
      private float j_zj;//�����۸�
      private float j_xj;//����۸�
      private String Lastupdate_ry;
      private String Lastupdate_sj;//����
      private String sj_xz;//�Ƿ��ϼ�
      private String Hasupload;//��д�ֶ�
      private String pict;//ͼƬ
      private String xzmc;//����
      private String ylmc;//ҽҩ����
      private String kx_xz;//����
      private String xj_xz;//��Ʒ
      private float j_cxj;//������
      private String st_lb;//�ִ�����,��;���ڿ�
      private float xsjg;//���ۼ۸�
      private float lsdj;//�������ۼ�
      private float cb4;//ҽ��֧����
      private int xlph;//��������
      private int djph;//�������
      private String searchName;//��̨������������ʱ�ֶ�
      private HuoDong huoDong;
      private int kysl;
      private String discount;//�۸��Żݱ�־
      private String pict_sm;//˵����ͼƬ
      private String spph;
      private float cxdj;//�����۸�
  	  
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
			if(ylmc.substring(0, 1).equals("��")) {
				return "��";
			}else if(ylmc.substring(0, 1).equals("��")) {
				return "��";
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
