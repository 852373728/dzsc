package com.sun.controller.Backstage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Spk;
import com.sun.entity.SpkLb;
import com.sun.service.BackSpkLbService;
import com.sun.service.BackSpkService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/backSpk")
public class BackSpkController {
	
	@Resource
	private BackSpkService backSpkService;
	@Resource
	private BackSpkLbService BackSpkLbService;

	@RequestMapping("/list")
	public String list(String spk_yjfl,String spk_ejfl,Integer page,Integer rows,Spk spk,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		map.put("spmc", StringUtil.formatLike(spk.getSpmc()));
		map.put("spk_ejfl", spk_ejfl);
		if(StringUtil.isNotEmpty(spk_yjfl)) {
			List<SpkLb> spkLbList = BackSpkLbService.findByLbParent(spk_yjfl);
			StringBuffer sb=new StringBuffer();
			for (SpkLb spkLb : spkLbList) {
				sb.append(","+spkLb.getLbdm());
			}
			String[] split = sb.toString().replaceFirst(",", "").split(",");
			map.put("array", split);
		}
		result.put("total", backSpkService.total(map));
		result.put("rows", backSpkService.list(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/listAll")
	public String listAll(Integer page,Integer rows,Spk spk,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		map.put("searchName", StringUtil.formatLike(spk.getSearchName()));
		map.put("sj_xz", spk.getSj_xz());
		map.put("kx_xz", spk.getKx_xz());
		map.put("st_lb", spk.getSt_lb());
		result.put("total", backSpkService.totalAll(map));
		result.put("rows", backSpkService.listAll(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	
}
