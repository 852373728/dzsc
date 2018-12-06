package com.sun.entity;

/**
 * 历史购买商品
 * @author sunqilin
 *
 */
public class HistoryGoods {

	private int id;
	private String spdm;//商品代码，唯一标示
	private String userName;//用户账号
	private int buyNum;//历史购买数量
	private String spmc;
	private String sccj1;
	private String dw;
	
	
	public HistoryGoods() {
		super();
	}
	
	public HistoryGoods(String spdm, String userName, int buyNum) {
		super();
		this.spdm = spdm;
		this.userName = userName;
		this.buyNum = buyNum;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getSccj1() {
		return sccj1;
	}

	public void setSccj1(String sccj1) {
		this.sccj1 = sccj1;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}
	
	
}
