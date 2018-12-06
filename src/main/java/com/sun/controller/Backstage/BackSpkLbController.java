package com.sun.controller.Backstage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.entity.SpkLb;
import com.sun.service.BackSpkLbService;
import com.sun.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/backSpkLb")
public class BackSpkLbController {
	
	@Resource
	private BackSpkLbService backSpkLbService;

	@RequestMapping("/combobox")
	public String combobox(@RequestParam(required=false,value="cjbz")Integer cjbz,HttpServletResponse response,String lbparent) throws Exception{
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("lbdm", "");
		jsonObject.put("lbmc", "请选择");
		jsonArray.add(jsonObject);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("cjbz", cjbz);
		map.put("lbparent", lbparent);
		List<SpkLb> SpkLbList = backSpkLbService.list(map);
		JSONArray rows = JSONArray.fromObject(SpkLbList);
		jsonArray.addAll(rows);
		ResponseUtil.write(jsonArray,response);
		return null;
	}
	
	@RequestMapping("/treeList")
	public String treeList(HttpServletResponse response,String lbparent) throws Exception{
		JSONArray jsonArray = oneList(lbparent);
		ResponseUtil.write(jsonArray,response);
		return null;
	}
	
	private JSONArray oneList(String lbparent) {
		List<SpkLb> SpkLbList = backSpkLbService.findByLbParent(lbparent);
		JSONArray jsonArray = JSONArray.fromObject(SpkLbList);
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if(jsonObject.getInt("cjbz")==1){
				jsonObject.put("children", oneList(jsonObject.getString("lbdm")));
			}else{
				continue;
			}
		}
		return jsonArray;
	}
	
	@RequestMapping("/save")
	public String save(String data,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		boolean flag = backSpkLbService.update(data);
		 if(flag) {
		    	result.put("state", true);
		    	result.put("msg", "修改成功");
		    }else {
		    	result.put("state", false);
		    	result.put("msg", "修改失败，请联系管理员！");
		    }
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/getOnebyLbdm")
	public String getOnebyLbdm(String lbdm,HttpServletResponse response) throws Exception{
		SpkLb spklb = backSpkLbService.getOnebyLbdm(lbdm);
		if(spklb!=null) {
			spklb.setSpkLb(backSpkLbService.getOnebyLbdm(spklb.getLbparent()));
		}
		ResponseUtil.write(JSONObject.fromObject(spklb), response);
		return null;
	}
	
	
}
