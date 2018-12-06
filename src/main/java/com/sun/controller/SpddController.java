package com.sun.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Kh;
import com.sun.service.KhService;
import com.sun.service.SpddService;
import com.sun.service.SpkService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;
import com.sun.util.Zz;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/spdd")
public class SpddController {

	@Resource
	private SpddService spddService;
	@Resource
	private KhService khService;
	@Resource
	private SpkService spkService;
	
	
	@RequestMapping("/add")
	public String add(String spdmStrs,String sls,String spphs,HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null || StringUtil.isEmpty(spdmStrs) || StringUtil.isEmpty(spphs) || StringUtil.isEmpty(sls) || Zz.numSz(sls)==false) {
			ResponseUtil.write(result, response);
			return null;
		}
		String msg = spkService.kysl(spdmStrs,sls,kh,spphs);
		if(msg!=null) {
			result.put("state", false);
			result.put("msg", msg);
			ResponseUtil.write(result, response);
			return null;
		}
		boolean flag = spddService.add(spdmStrs,sls,khService.find(kh),spphs);
		if(flag) {
			result.put("state", true);
			result.put("msg", "商品购买成功！");
			ResponseUtil.write(result, response);
			return null;
		}else {
			result.put("state", false);
			result.put("msg", "商品购买失败！");
			ResponseUtil.write(result, response);
			return null;
		}
	}
	
	@RequestMapping("/getOne")
	public String getOne(String ddbh,HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null || StringUtil.isEmpty(ddbh)) {
			ResponseUtil.write(result, response);
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("ddbh", ddbh);
		result.put("spdd", spddService.getOne(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/list")
	public String list(HttpServletResponse response,HttpServletRequest request,String startTime,String endTime,String zt) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			ResponseUtil.write(result, response);
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", kh.getEmail());
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("zt", zt);
		result.put("spddList", spddService.list(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	
	
	
	
}
