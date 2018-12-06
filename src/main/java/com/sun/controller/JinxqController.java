package com.sun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.entity.Spk;
import com.sun.service.SpkService;
import com.sun.service.impl.JinxqService;
import com.sun.util.FormatMath;
import com.sun.util.PageSize;
import com.sun.util.Zz;

@Controller
@RequestMapping("/jinxq")
public class JinxqController {
	
	@Resource
	private JinxqService jinxqService;
	@Resource
	private SpkService spkService;

	@RequestMapping("")
	public ModelAndView list(String page,String web_splbdm,String jxmc,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		Map<String, Object> map=new HashMap<String, Object>();
		Integer formatPage = FormatMath.format(page, "[1-9]\\d*");
		map.put("page",  formatPage);
		map.put("size", PageSize.SIZE);
		map.put("web_splbdm", web_splbdm);
		map.put("jxmc", jxmc);
		mav.addObject("twoSplbList", jinxqService.findSplbTwo(map));
		mav.addObject("jxList", jinxqService.findJx(map));
		mav.addObject("rows", jinxqService.list(map,request));
		mav.addObject("total", jinxqService.total(map));
		mav.addObject("page", formatPage);
		mav.addObject("size", PageSize.SIZE);
		mav.addObject("hotNew", spkService.hotNew());
		mav.setViewName("jinxq");
		return mav;
	}
	
	@RequestMapping("/getOne")
	public ModelAndView getOne(String id,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		if(!Zz.num(id)) {
			mav.setViewName("redirect:/lost.jsp");
			return mav;
		}
		Spk spk = jinxqService.getOne(id, request);
		if(spk==null) {
			mav.setViewName("redirect:/lost.jsp");
			return mav;
		}
		mav.addObject("spk", spk);
		mav.setViewName("jinxqGood");
		return mav;
	}
	
}
