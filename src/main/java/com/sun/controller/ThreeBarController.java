package com.sun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.service.ThreeBarService;
import com.sun.util.FormatMath;
import com.sun.util.PageSize;

@Controller
public class ThreeBarController {

	@Resource
	private ThreeBarService threeBarService;
	
	@RequestMapping("/threeBar")
	public ModelAndView threeBar(@RequestParam(value="page",required=false)String page) {
		ModelAndView mav=new ModelAndView();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", FormatMath.format(page, "[1-9]\\d*"));
		map.put("size", PageSize.SIZE);
		mav.addObject("threeBar", threeBarService.fenye(map));
		mav.addObject("total", threeBarService.total(map));
		mav.addObject("page", FormatMath.format(page, "[1-9]\\d*"));//当前页
		mav.addObject("size", PageSize.SIZE);//一页显示条数
		mav.setViewName("huodongThreeLevel");
		return mav;
	}
}
