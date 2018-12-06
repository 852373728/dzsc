package com.sun.controller.Backstage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Sccj;
import com.sun.service.BackSccjService;
import com.sun.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/backSccj")
public class BackSccjController {

	@Resource
	private BackSccjService backSccjService;
	
	@RequestMapping("/list")
	public String list(Integer page,Integer rows,HttpServletResponse response,Sccj sccj) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		result.put("total", backSccjService.total(map));
		result.put("rows", backSccjService.list(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(HttpServletResponse response,Sccj sccj) throws Exception{
		JSONObject result=new JSONObject();
		boolean flag=false;
		if(sccj.getId()==0) {
			
		}else {
			flag = backSccjService.update(sccj);
		}
		if(flag) {
			result.put("state", true);
			result.put("msg", "保存成功");
		}else {
			result.put("state", false);
			result.put("msg", "保存失败，请联系管理员");
		}
		ResponseUtil.write(result, response);
		return null;
	}
	
}
