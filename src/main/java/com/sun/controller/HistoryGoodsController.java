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
import com.sun.service.impl.HistoryGoodsService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/historyGoods")
public class HistoryGoodsController {
	@Resource
	private KhService khService;
	@Resource
	private HistoryGoodsService historyGoodsService;
	
	@RequestMapping("/list")
	public String list(HttpServletResponse response,HttpServletRequest request,String searchName) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			ResponseUtil.write(result, response);
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", kh.getEmail());
		map.put("searchName",StringUtil.formatLike(searchName));
		result.put("hgList", historyGoodsService.findByUserName(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
}
