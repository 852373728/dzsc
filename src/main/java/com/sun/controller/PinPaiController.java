package com.sun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.entity.Kh;
import com.sun.entity.Sccj;
import com.sun.service.KhService;
import com.sun.service.SccjService;
import com.sun.service.SpkService;
import com.sun.util.FormatMath;
import com.sun.util.PageSize;
import com.sun.util.StringUtil;

@Controller
public class PinPaiController {

	@Resource
	private SccjService sccjService;
	@Resource
	private SpkService spkService;
	@Resource
	private KhService khService;
	
	@RequestMapping("/pinpai")
	public ModelAndView home(@RequestParam(value="page",required=false)String page,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", FormatMath.format(page, "[1-9]\\d*"));
		map.put("size", PageSize.SCCJSIZE);
		mav.addObject("total", sccjService.total(map));
		mav.addObject("page", FormatMath.format(page, "[1-9]\\d*"));//当前页
		mav.addObject("size", PageSize.SCCJSIZE);//一页显示条数
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			mav.addObject("listSccj", sccjService.fenye(map,false,null));
		}else {
			mav.addObject("listSccj", sccjService.fenye(map,true,kh));
		}
		mav.setViewName("pinpai");
		return mav;
	}
	
	@RequestMapping("/pinpaiDetails")
	public ModelAndView sccj(@RequestParam(value="page",required=false)String page,@RequestParam(value="cjmc",required=false)String cjmc,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		if(StringUtil.isEmpty(cjmc)) {
			mav.setViewName("redirect:/lost.jsp");
			return mav;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", FormatMath.format(page, "[1-9]\\d*"));
		map.put("size", PageSize.SIZE);
		mav.addObject("page", FormatMath.format(page, "[1-9]\\d*"));//当前页
		mav.addObject("size", PageSize.SIZE);//一页显示条数
		mav.addObject("hotNew", spkService.hotNew());
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			Sccj sccj = sccjService.getSccj(cjmc, map,false,null);
			if(sccj==null) {
				mav.setViewName("redirect:/lost.jsp");
				return mav;
			}
			mav.addObject("sccj", sccj);
			mav.addObject("total", sccj.getSpkTotal());
		}else {
			Sccj sccj = sccjService.getSccj(cjmc, map,true,kh);
			if(sccj==null) {
				mav.setViewName("redirect:/lost.jsp");
				return mav;
			}
			mav.addObject("sccj", sccj);
			mav.addObject("total", sccj.getSpkTotal());
		}
		mav.setViewName("pinpaiDetails");
		return mav;
	}
	
}
