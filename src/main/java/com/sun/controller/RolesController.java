package com.sun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Kh;
import com.sun.service.KhService;
import com.sun.service.RolesPermissionsService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/rolePermission")
public class RolesController {

	@Resource
	private KhService khService;
	@Resource
	private RolesPermissionsService rolesPermissionsService;
	
	@RequestMapping(value="/selectPermission")
	public String selectPermission(HttpServletResponse response,HttpServletRequest request,String str,String roleName) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh(request);
		if(kh==null || StringUtil.isEmpty(roleName)) {
			ResponseUtil.write(result, response);
			return null;
		}
		boolean flag = rolesPermissionsService.add(roleName, str);
		if(flag) {
			result.put("status", true);
			result.put("msg", "权限修改成功");
			ResponseUtil.write(result, response);
			return null;
		}else {
			result.put("status", false);
			result.put("msg", "权限修改失败");
			ResponseUtil.write(result, response);
			return null;
		}
	}
	
}
