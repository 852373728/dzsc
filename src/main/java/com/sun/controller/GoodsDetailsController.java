package com.sun.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.dao.HuoDongDao;
import com.sun.entity.HuoDong;
import com.sun.entity.Kh;
import com.sun.entity.Spk;
import com.sun.service.KhService;
import com.sun.service.SpkService;
import com.sun.util.StringUtil;

@Controller
@RequestMapping("/goodsDetails")
public class GoodsDetailsController {

	@Resource
	private SpkService spkService;
	@Resource
	private HuoDongDao huoDongDao;
	@Resource
	private KhService khService;
	
	@RequestMapping("")
	public ModelAndView goods(String id,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		if(StringUtil.isEmpty(id)) {
			mav.setViewName("redirect:/lost.jsp");
			return mav;
		}
		String pattern = "\\d*";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(id);
		if(!m.matches()){
			mav.setViewName("redirect:/lost.jsp");
			return mav;
		}
		Kh kh = khService.noHasKh_Zt2(request);
		if(kh==null) {
			Spk spk = spkService.getOne(Integer.parseInt(id));
			if(spk==null) {
				mav.setViewName("redirect:/lost.jsp");
				return mav;
			}
			HuoDong huoDong = huoDongDao.getBySpkId(spk.getId());
			if(huoDong!=null) {
				huoDong.setHuoDongContent("µÇÂ½¿É¼û");
			}
			spk.setHuoDong(huoDong);
			mav.addObject("spk", spk);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("web_splbdm", spk.getWeb_splbdm());
			map.put("px", "xlph");
			mav.addObject("reXiaoList", spkService.goodRight(map,false,null));
			map.put("px", "djph");
			mav.addObject("xinPinList", spkService.goodRight(map,false,null));
			map.clear();
			map.put("SCCJ1", spk.getSCCJ1());
			mav.addObject("listSpkBySccj", spkService.findBySCCJ1(map,false,null));
			map.clear();
			map.put("ph", "djph");
			map.put("id", spk.getId());
			spkService.editph(map);
			mav.setViewName("goodsDetails");
			return mav;
		}else {
			Spk spk = spkService.getOneUser(Integer.parseInt(id),kh);
			if(spk==null) {
				mav.setViewName("redirect:/lost.jsp");
				return mav;
			}
			spk.setHuoDong(huoDongDao.getBySpkId(spk.getId()));
			mav.addObject("spk", spk);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("web_splbdm", spk.getWeb_splbdm());
			map.put("px", "xlph");
			mav.addObject("reXiaoList", spkService.goodRight(map,true,kh));
			map.put("px", "djph");
			mav.addObject("xinPinList", spkService.goodRight(map,true,kh));
			map.clear();
			map.put("SCCJ1", spk.getSCCJ1());
			mav.addObject("listSpkBySccj", spkService.findBySCCJ1(map,true,kh));
			map.clear();
			map.put("ph", "djph");
			map.put("id", spk.getId());
			spkService.editph(map);
			mav.setViewName("goodsDetails");
			return mav;
		}
	}
}
