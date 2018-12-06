package com.sun.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Kh;
import com.sun.entity.Zzzl;
import com.sun.service.KhService;
import com.sun.service.QylxService;
import com.sun.service.impl.ZzzlService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;
import com.sun.util.Zz;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/kh")
public class KhController {

	@Resource
	private QylxService qylxService;
	
	@Resource
	private KhService khService;
	@Resource
	private ZzzlService zzzlService;

	@RequestMapping("/login")
	public  String login(Kh kh,String imageCode,HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject map=new JSONObject();
		if(StringUtil.isEmpty(kh.getEmail())) {
			map.put("state", false);
			map.put("msg", "请输入账号！");
			ResponseUtil.write(map, response);
			return null;
		}
		if(StringUtil.isEmpty(kh.getPassword())) {
			map.put("state", false);
			map.put("msg", "请输入密码！");
			ResponseUtil.write(map, response);
			return null;
		}
		if(StringUtil.isEmpty(imageCode)) {
			map.put("state", false);
			map.put("msg", "请输入验证码！");
			ResponseUtil.write(map, response);
			return null;
		}
		HttpSession session = request.getSession();
		String sRand=(String) session.getAttribute("sRand");
		if(!sRand.equalsIgnoreCase(imageCode)) {
			map.put("state", false);
			map.put("msg", "验证码输入有误！");
			ResponseUtil.write(map, response);
			return null;
		}
		Kh resultkh = khService.find(kh);
		if(resultkh==null) {
			map.put("state", false);
			map.put("msg", "账号或密码输入有误！");
			ResponseUtil.write(map, response);
			return null;
		}
		Zzzl zzzl = zzzlService.judge(kh.getEmail());
		if(zzzl!=null) {
			map.put("state", false);
			map.put("msg", zzzl.getZzmc()+"过期！无法登陆");
			ResponseUtil.write(map, response);
			return null;
		}
		map.put("state", true);
		map.put("currentUser", resultkh);
		ResponseUtil.write(map, response);
		return null;
	}
	
	/**
	 * zt为2
	 * @param kh
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/reload")
	public String reload(HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject map=new JSONObject();
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			map.put("state", false);
			ResponseUtil.write(map, response);
			return null;
		}else {
			map.put("state", true);
			map.put("currentUser", kh);
			ResponseUtil.write(map, response);
			return null;
		}
	}
	
	/**
	 * zt为1
	 * @param kh
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ztOne")
	public String ztOne(HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject map=new JSONObject();
		Kh kh = khService.noHasKh(request);
		if(kh==null) {
			map.put("state", false);
			ResponseUtil.write(map, response);
			return null;
		}else {
			map.put("state", true);
			map.put("currentUser", kh);
			ResponseUtil.write(map, response);
			return null;
		}
	}
	
	@RequestMapping("/editPwd")
	public String editPwd(String pwd,HttpServletResponse response,HttpServletRequest request) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh(request);
		if(kh==null || !Zz.pwd(pwd)) {
			ResponseUtil.write(result, response);
			return null;
		}
		if(kh.getSt_userclass().equals("客户") && !kh.getZt().equals("2")) {
			ResponseUtil.write(result, response);
			return null;
		}
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("email", kh.getEmail());
		map.put("password", pwd);
		boolean flag = khService.editPwd(map);
		if(flag) {
	    	result.put("state", true);
	    	result.put("msg", "密码修改成功,请重新登录！");
	    }else {
	    	result.put("state", false);
	    	result.put("msg", "密码修改失败，请稍候再试！");
	    }
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/zzzl")
	public String zzzl(HttpServletResponse response,HttpServletRequest request) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh(request);
		if(kh!=null) {
			Zzzl zzzl = zzzlService.judge(kh.getEmail());
			if(zzzl!=null) {
				result.put("state", false);
				result.put("msg", zzzl.getZzmc()+"过期，证照id："+zzzl.getZzid()+"！无法登陆");
				ResponseUtil.write(result, response);
				return null;
			}
		}
		ResponseUtil.write(result, response);
		return null;
	}
	
	
	
	
}
