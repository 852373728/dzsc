package com.sun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.dao.SpkDao;
import com.sun.dao.UseKhDao;
import com.sun.entity.Kh;
import com.sun.entity.ShopCar;
import com.sun.entity.Spk;
import com.sun.service.KhService;
import com.sun.service.ShopCarService;
import com.sun.service.SpkService;
import com.sun.service.impl.JinxqService;
import com.sun.util.FormatMath;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;
import com.sun.util.Zz;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/shopCar")
public class ShopCarController {

	@Resource
	private ShopCarService shopCarService;
	@Resource
	private KhService khService;
	@Resource
	private SpkService spkService;
	@Resource
	private UseKhDao useKhDao;
	@Resource
	private SpkDao spkDao;
	@Resource
	private JinxqService jinxqService;

	@RequestMapping("/add")
	public String add(String spdm,String num,HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null || StringUtil.isEmpty(spdm) || !Zz.num(num)) {
			ResponseUtil.write(result, response);
			return null;
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("spdm", spdm);
		Spk spk = spkService.getOneUserBymap(map);
		if(spk.getXsjg()<=0.0) {
			result.put("state", false);
			result.put("msg", spk.getSpmc()+"价格有误，暂时无法添加到购物车！");
			ResponseUtil.write(result, response);
			return null;
		}
		
		if(spk.getKysl()<Integer.parseInt(num)) {
			result.put("state", false);
			result.put("msg", spk.getSpmc()+"库存数量不足！");
			ResponseUtil.write(result, response);
			return null;
		}
		if(spk!=null && StringUtil.isNotEmpty(spk.getQy_xz())) {
			List<String> list = useKhDao.listK(spk.getQy_xz());
			if(!list.contains(kh.getKhdm())) {
				result.put("state", false);
				result.put("msg", "您不符合购买此商品的要求，请谅解！");
				ResponseUtil.write(result, response);
				return null;
			}
		}
		
		map.put("username", kh.getEmail());
		ShopCar shopCar =new ShopCar(spdm,FormatMath.format(num, "\\d*"),kh.getEmail());
		List<ShopCar> carlist = shopCarService.list(map);
		if(carlist!=null && carlist.size()>0) {
			shopCarService.update(shopCar);
		}else {
			shopCarService.add(shopCar);
			Long total = shopCarService.Count(map);
			result.put("shopCarCount", total);
		}
		
		result.put("state", true);
		result.put("msg", "商品已添加至购物车！");
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/count")
	public String count(HttpServletResponse response,HttpServletRequest request)throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			ResponseUtil.write(result, response);
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", kh.getEmail());
		Long total = shopCarService.Count(map);
		result.put("shopCarCount", total);
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletResponse response,String id,HttpServletRequest request) throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			ResponseUtil.write(result, response);
			return null;
		}
		shopCarService.delete(FormatMath.format(id, "\\d*", "0"));
		result.put("state", true);
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/addcx")
	public String addcx(String spdm,String spph,String num, HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null || StringUtil.isEmpty(spdm) || !Zz.num(num) || StringUtil.isEmpty(spph)) {
			ResponseUtil.write(result, response);
			return null;
		}
		int numint = Integer.parseInt(num);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("spdm", spdm);
		map.put("spph", spph);
		Long findKc = jinxqService.findKc(map);
		if(findKc<numint) {
			result.put("msg", "商品库存不足");
			ResponseUtil.write(result, response);
			return null;
		}
		ShopCar shopCar=new ShopCar(spdm,spph,numint,kh.getEmail());
		if(shopCarService.judgeExit(shopCar)==0) {
			shopCarService.addCx(shopCar);
			map.clear();
			map.put("username", kh.getEmail());
			Long total = shopCarService.Count(map);
			result.put("shopCarCount", total);
		}else {
			shopCarService.editExit(shopCar);
		}
		
		result.put("msg", "商品已添加至购物车！");
		ResponseUtil.write(result, response);
		return null;
	}
	
	
}
