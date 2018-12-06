package com.sun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.dao.BackShopCarMsgDao;
import com.sun.dao.HistoryGoodsDao;
import com.sun.dao.HuoDongDao;
import com.sun.dao.JinxqDao;
import com.sun.dao.ShopCarDao;
import com.sun.dao.SpddDao;
import com.sun.dao.SpddMxDao;
import com.sun.dao.SpkDao;
import com.sun.entity.HistoryGoods;
import com.sun.entity.HuoDong;
import com.sun.entity.Jinxq;
import com.sun.entity.Kh;
import com.sun.entity.ShopCarMsg;
import com.sun.entity.Spdd;
import com.sun.entity.SpddMx;
import com.sun.entity.Spk;
import com.sun.service.SpddService;
import com.sun.util.DateUtil;
import com.sun.util.StringUtil;

@Service("spddService")
public class SpddServiceImpl implements SpddService{

	@Resource
	private SpddDao spddDao;
	@Resource
	private SpkDao spkDao;
	@Resource
	private SpddMxDao spddMxDao;
	@Resource
	private ShopCarDao ShopCarDao;
	@Resource
	private HuoDongDao huoDongDao;
	@Resource
	private HistoryGoodsDao historyGoodsDao;
	@Resource
	private BackShopCarMsgDao backShopCarMsgDao;
	@Resource
	private JinxqDao jinxqDao;
	
	/**
	 * 添加订单
	 * @param spdd
	 */
	@SuppressWarnings("unused")
	@Transactional
	public boolean add(String spdmStrs,String sls,Kh kh,String spphs){
			Map<String, Object> map=new HashMap<String, Object>();
			Map<String, Object> map1=new HashMap<String, Object>();
			Map<String, Object> map2=new HashMap<String, Object>();
			Map<String, Object> discountMap=new HashMap<String, Object>();
			Map<String, Object> cxMap=new HashMap<String, Object>();
			map2.put("ph", "xlph");
			String maxddh = maxddh();//获得订单编号
			String[] spdm = spdmStrs.split(",");
			String[] sl = sls.split(",");
			String[] spph = spphs.split(",");
			double total=0;
			for(int i=0;i<spdm.length;i++) {
				boolean discountbl=true;//标记，如果一个商品有当前客户特别价格，优先特别价格，整价靠后
				//获得该商品信息
				map.put("spdm", spdm[i]);
				Spk spk = spkDao.getOneUserBymap(map);
				//是否为促销商品
				if(!spph[i].equals("sun")) {
					cxMap.put("spdm", spdm[i]);
					cxMap.put("spph", spph[i]);
					Jinxq jinxq = jinxqDao.getOne(cxMap);
					spk.setXsjg(jinxq.getCxdj());
					discountbl=false;
				}
				//查看该商品是否对当前客户特别指定价格
				discountMap.put("spdm", spk.getSpdm());
				discountMap.put("khdm", kh.getKhdm());
				Float discount = spkDao.discount(discountMap);
				if(discount!=null && discount>0) {
					spk.setXsjg(discount);
					discountbl=false;
				}
				//查看该商品是否有活动
				String hdnr="";
				HuoDong huoDong = huoDongDao.getBySpkId(spk.getId());
				if(huoDong!=null) {
					hdnr=huoDong.getHuoDongContent();
				}
				//判断该商品是否是整件销售
				if(spk.getJ_zj()!=0.0 && spk.getWbzsl()!=0 && Integer.parseInt(sl[i])%spk.getWbzsl()==0 && discountbl) {
					spk.setXsjg(spk.getJ_zj());
				}
				//累计订单总价
				total+=spk.getXsjg()*Integer.parseInt(sl[i]);
				//添加订单明细
				SpddMx spddMx=new SpddMx(spk.getSpdm(),spk.getSpmc(),spk.getDw(),spk.getSpgg(),spk.getXsjg(),Integer.parseInt(sl[i]),maxddh,hdnr);
				if(!spph[i].equals("sun")) {
					spddMx.setSpph(spph[i]);
				}
				spddMxDao.add(spddMx);
				//删除购物车
				map1.put("spdm", spk.getSpdm());
				map1.put("username", kh.getEmail());
				ShopCarDao.deleteByMap(map1);
				//修改商品库的销售量和在提数量
				if(!spph[i].equals("sun")) {
					cxMap.put("sl", sl[i]);
					jinxqDao.editZtsl(cxMap);
				}else {
					map2.put("num", sl[i]);
					map2.put("id", spk.getId());
					spkDao.editph(map2);
				}
				
				//历史采购药品
				if(historyGoodsDao.exit(map1)==0) {
					historyGoodsDao.add(new HistoryGoods(spk.getSpdm(), kh.getEmail(),Integer.parseInt(sl[i])));
				}else {
					historyGoodsDao.update(new HistoryGoods(spk.getSpdm(), kh.getEmail(),Integer.parseInt(sl[i])));
				}
			}
			//判断订单总价是否高于设定总价，订单总价小于标准价则报错回滚业务
			ShopCarMsg shopCarMsg = backShopCarMsgDao.getOne(1);
			if(shopCarMsg!=null) {
				if(total<shopCarMsg.getZj()) {
					int i=5/0;
					return false;
				}
			}
			
			//添加订单总表
			Spdd spdd=new Spdd(maxddh,total,new Date(),kh.getEmail(),kh.getDwmc(),kh.getLxr(),kh.getLxdh(),kh.getAdress(),"1",kh.getYwybh(),kh.getYwyxm(),kh.getKhdm());
			spddDao.add(spdd);
			return true;
	}
	
	/**
	 * 查询当天最大的订单编号
	 * @return
	 */
	public String maxddh() {
		StringBuffer code=new StringBuffer("DDBH");
		code.append(DateUtil.getCurrentDateStr());
		String ddbh=spddDao.maxddh();
		if(ddbh!=null){
			code.append(StringUtil.formatCode(ddbh));
		}else{
			code.append("0001");
		}
		return code.toString();
	}
	
	/**
	 * 商品订单主表的查询，根据各种条件
	 * @param map
	 * @return
	 */
	public List<Spdd> list(Map<String, Object> map){
		return spddDao.list(map);
	}
	
	/**
	 * 根据条件查询一个spdd
	 * @param map
	 * @return
	 */
	public Spdd getOne(Map<String, Object> map) {
		Spdd spdd = spddDao.getOne(map);
		spdd.setFormatZdrq(DateUtil.formatDate(spdd.getZdrq()));
		spdd.setSpddMxList(spddMxDao.list(map));
		return spdd;
	}
	
	
	
}
