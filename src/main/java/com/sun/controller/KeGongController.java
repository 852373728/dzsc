package com.sun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.entity.Kh;
import com.sun.entity.Spk;
import com.sun.entity.SpkLb;
import com.sun.service.KhService;
import com.sun.service.SpkLbService;
import com.sun.service.SpkService;
import com.sun.util.FormatMath;
import com.sun.util.PageSize;
import com.sun.util.StringUtil;

@Controller
@RequestMapping("/kegong")
public class KeGongController {
	
	@Resource
	private SpkService spkService;
	@Resource
	private SpkLbService spkLbService;
	@Resource
	private KhService khService;
	
	@RequestMapping("")
	public ModelAndView findSpkList(Spk spk, @RequestParam(value="page",required=false)String page,@RequestParam(value="web_splbdm1",required=false)String web_splbdm1,@RequestParam(value="bigSearch",required=false)String bigSearch,@RequestParam(value="listPh",required=false)String listPh,HttpServletRequest request) throws Exception{
		ModelAndView mav=new ModelAndView();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", FormatMath.format(page, "[1-9]\\d*"));
		map.put("size", PageSize.SIZE);
		String[] split= {};
		if(StringUtil.isNotEmpty(web_splbdm1)) {
			List<SpkLb> spkLbTwo = spkLbService.findByLbParent(web_splbdm1);
			StringBuffer sb=new StringBuffer();
			for (SpkLb spkLb : spkLbTwo) {
				sb.append(","+spkLb.getLbdm());
			}
			split = sb.toString().replaceFirst(",", "").split(",");
			
		}
		map.put("listPh", FormatMath.format(listPh, "[1-3]"));
		map.put("array", split);
		map.put("web_splbdm", spk.getWeb_splbdm());
		map.put("SCCJ1", spk.getSCCJ1());
		map.put("jxmc", spk.getJxmc());
		map.put("xzmc", spk.getXzmc());
		map.put("ylmc", StringUtil.formatLike(spk.getYlmc()));
		map.put("qy_xz", spk.getQy_xz());
		if(StringUtil.isNotEmpty(bigSearch)) {
			bigSearch=bigSearch.toUpperCase();
		}
		map.put("bigSearch", StringUtil.formatLike(bigSearch));
		mav.addObject("total", spkService.total(map));
		mav.addObject("page", FormatMath.format(page, "[1-9]\\d*"));//当前页
		mav.addObject("size", PageSize.SIZE);//一页显示条数
		mav.addObject("splbTwoList", spkService.findSplbTwo(map));
		mav.addObject("splbOneList", spkService.findSplbOne(map));
		mav.addObject("sccjList", spkService.findSccj(map));
		mav.addObject("jxList", spkService.findJx(map));
		mav.addObject("xzList", spkService.findXz(map));
		mav.addObject("ylList", spkService.findyl(map));
		mav.addObject("bigSearch", bigSearch);
		mav.addObject("hotNew", spkService.hotNew());
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			mav.addObject("spkList", spkService.findSpkList(map,false,null));
		}else {
			mav.addObject("spkList", spkService.findSpkList(map,true,kh));
		}
		mav.setViewName("kegong");
		return mav;
		
	}
}
