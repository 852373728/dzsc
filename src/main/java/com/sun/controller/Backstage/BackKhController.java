package com.sun.controller.Backstage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Kh;
import com.sun.service.BackKhService;
import com.sun.util.DateJsonValueProcessor;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/admin/backKh")
public class BackKhController {

	@Resource
	private BackKhService backKhService;
	
	@RequestMapping("/list")
	public String list(Integer page,Integer rows,HttpServletResponse response,Kh kh) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray=JSONArray.fromObject(backKhService.list(map), jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", backKhService.total(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(HttpServletResponse response,Kh kh) throws Exception{
		JSONObject result=new JSONObject();
		boolean flag=false;
		if(StringUtil.isEmpty(kh.getEmail())) {
			
		}else {
			flag = backKhService.update(kh);
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
	
	@RequestMapping("/delete")
	public String delete(String emails,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		boolean flag = backKhService.delete(emails);
		if(flag) {
			result.put("state", true);
			result.put("msg", "删除成功");
		}else {
			result.put("state", false);
			result.put("msg", "删除失败，请联系管理员");
		}
		ResponseUtil.write(result, response);
		return null;
	}
	
}
