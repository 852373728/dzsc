package com.sun.controller.Backstage;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Admin;
import com.sun.util.CryptographyUtil;
import com.sun.util.StringUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/login")
	public String login(Admin admin,HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		if(StringUtil.isEmpty(admin.getUserName()) || StringUtil.isEmpty(admin.getPassword()) ) {
			return "redirect:/admin/login.jsp";
		}
		UsernamePasswordToken token=new UsernamePasswordToken(admin.getUserName(),CryptographyUtil.md5(admin.getPassword(), "sun"));
		try {
			subject.login(token);
			return "redirect:/admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("admin", admin);
			request.setAttribute("errorInfo", "用户名或密码错误");
			return "admin/login";
		}
	}
	
}

