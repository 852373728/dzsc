package com.sun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Collect;
import com.sun.entity.Kh;
import com.sun.service.CollectionService;
import com.sun.service.KhService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;
import com.sun.util.Zz;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/collection")
public class CollectionController {
	@Resource
	private CollectionService collectionService;
	@Resource
	private KhService khService;

	@RequestMapping("/save")
	public String save(String spdm,HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null || StringUtil.isEmpty(spdm)) {
			ResponseUtil.write(result, response);
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("spdm", spdm);
		map.put("userName", kh.getEmail());
		Long exit = collectionService.exit(map);
		if(exit!=0) {
			result.put("state", false);
	    	result.put("msg", "该商品已收藏");
	    	ResponseUtil.write(result, response);
			return null;
		}
		boolean flag = collectionService.add(new Collect(spdm, kh.getEmail()));
		if(flag) {
	    	result.put("state", true);
	    	result.put("msg", "收藏成功");
	    }else {
	    	result.put("state", false);
	    	result.put("msg", "收藏失败，请稍候再试！");
	    }
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/list")
	public String list(HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			ResponseUtil.write(result, response);
			return null;
		}
		List<Collect> collectList = collectionService.findByUserName1(kh.getEmail());
		result.put("collectList", collectList);
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null || !Zz.num(id)) {
			ResponseUtil.write(result, response);
			return null;
		}
		boolean flag = collectionService.delete(Integer.parseInt(id));
		if(flag) {
	    	result.put("state", true);
	    	result.put("msg", "已取消");
	    }else {
	    	result.put("state", false);
	    	result.put("msg", "取消失败，请稍候再试！");
	    }
		ResponseUtil.write(result, response);
		return null;
	}
	
	
	
}
