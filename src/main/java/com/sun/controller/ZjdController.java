package com.sun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Kh;
import com.sun.service.KhService;
import com.sun.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/zjd")
public class ZjdController {

	@Resource
	private KhService khService;
	
	@RequestMapping(value="")
	public String zjd(HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null || !kh.getSt_userclass().equals("¿Í»§")) {
			result.put("status", false);
			ResponseUtil.write(result, response);
			return null;
		}else {
			result.put("status", true);
			result.put("khdm", kh.getKhdm());
			ResponseUtil.write(result, response);
			return null;
		}
	}
	
}
