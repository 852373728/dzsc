package com.sun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.entity.Kh;
import com.sun.service.KhService;
import com.sun.service.MainShowService;
import com.sun.service.NavigationBarService;
import com.sun.service.SpkLbService;
import com.sun.service.SpkService;

@Controller
public class HomePageController {
	
	@Resource
	private MainShowService mainShowService;
	
	@Resource
	private SpkService spkService;
	
	@Resource
	private NavigationBarService navigationBarService;
	
	@Resource
	private SpkLbService spkLbService;
	
	@Resource
	private KhService khService;
	
	@RequestMapping("/homePage")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("sywzdm", "2");
		map.put("showSize", 6);
		mav.addObject("listCarousel",mainShowService.findListBySywzdm(map));
		mav.addObject("listShouyexpss",spkService.shouyexpss());
		mav.addObject("saleList",spkService.sale());
		mav.addObject("clickList",spkService.click());
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			mav.addObject("listHdatj",navigationBarService.hdatj(false,null));
		}else {
			mav.addObject("listHdatj",navigationBarService.hdatj(true,kh));
		}
		mav.setViewName("homePage");
		return mav;
	}
	
}
