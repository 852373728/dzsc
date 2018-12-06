package com.sun.controller.Backstage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.TwoBar;
import com.sun.service.BackTwoBarService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/BackTwobar")
public class TwoBarController {

	@Resource
	private BackTwoBarService backTwoBarService;
	
	@RequestMapping("/list")
	public String list(Integer page,Integer rows,HttpServletResponse response,TwoBar twoBar) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		map.put("barId", twoBar.getBarId());
		map.put("name", StringUtil.formatLike(twoBar.getName()));
		result.put("total", backTwoBarService.total(map));
		result.put("rows", backTwoBarService.list(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(HttpServletResponse response,TwoBar twoBar) throws Exception{
		JSONObject result=new JSONObject();
		boolean flag=false;
		if(twoBar.getId()==0) {
			flag = backTwoBarService.add(twoBar);
		}else {
			flag = backTwoBarService.update(twoBar);
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
	public String delete(String ids,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		
		boolean flag = backTwoBarService.delete(ids);
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
	
	@RequestMapping("/combobox/{barid}")
	public String combobox(@PathVariable("barid")Integer barid,HttpServletResponse response) throws Exception{
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("id", 0);
		jsonObject.put("name", "请选择");
		jsonObject.put("selected", true);
		jsonArray.add(jsonObject);
		List<TwoBar> findByBarId = backTwoBarService.findByBarId(barid);
		JSONArray rows = JSONArray.fromObject(findByBarId);
		jsonArray.addAll(rows);
		ResponseUtil.write(jsonArray,response);
		return null;
	}
	
}
