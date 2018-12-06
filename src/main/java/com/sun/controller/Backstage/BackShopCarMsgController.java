package com.sun.controller.Backstage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.ShopCarMsg;
import com.sun.service.impl.BackShopCarMsgService;
import com.sun.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/backScMsg")
public class BackShopCarMsgController {

	@Resource
	private BackShopCarMsgService backShopCarMsgService;
	
	@RequestMapping("/update")
	public String add(ShopCarMsg shopCarMsg,HttpServletResponse response) {
		backShopCarMsgService.update(shopCarMsg);
		return null;
	}
	
	@RequestMapping("/list")
	public String list(HttpServletResponse response) throws Exception {
		JSONObject result=new JSONObject();
		result.put("rows", backShopCarMsgService.list());
		ResponseUtil.write(result, response);
		return null;
	}
	
	
	
}
