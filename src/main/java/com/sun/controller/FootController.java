package com.sun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.service.impl.BackShopCarMsgService;
import com.sun.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/foot")
public class FootController {

	@Resource
	private BackShopCarMsgService backShopCarMsgService;
	
	@RequestMapping("/getOne")
	public String getOne(HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		result.put("msg",backShopCarMsgService.getOne(2));
		ResponseUtil.write(result, response);
		return null;
	}
}
