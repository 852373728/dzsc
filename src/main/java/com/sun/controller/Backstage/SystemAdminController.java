package com.sun.controller.Backstage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sun.entity.MainShow;
import com.sun.entity.SpkLb;
import com.sun.service.MainShowService;
import com.sun.service.NavigationBarService;
import com.sun.service.SpkLbService;
import com.sun.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("admin/refresh")
public class SystemAdminController {

	@Resource
	private MainShowService mainShowService;
	@Resource
	private NavigationBarService navigationBarService;
	@Resource
	private SpkLbService spkLbService;
	
	/**
	 * 刷新系统缓存
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("")
	public String refreshSystem(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("sywzdm", "1");
		map.put("showSize", 6);
		List<MainShow> hotList = mainShowService.findListBySywzdm(map);
		application.setAttribute("hotList", hotList);
		
		application.setAttribute("navigationBarList", navigationBarService.finList());
		
		application.setAttribute("allSpkLbByLbparent", allSpkLbList(spkLbService, "z"));
		
		JSONObject result=new JSONObject();
		result.put("state", true);
		result.put("msg", "缓存已刷新！");
		ResponseUtil.write(result, response);
		return null;
	}
	
	/**
	 * 递归获得商品分类一二级
	 * @param spkLbService
	 * @param lbparent
	 * @return
	 */
	private List<SpkLb> allSpkLbList(SpkLbService spkLbService,String lbparent){
		List<SpkLb> spkLbList = oneSpkLbListByLbParent(spkLbService, lbparent);
		for (SpkLb spkLb : spkLbList) {
			if(spkLb.getCjbz()==1) {
				spkLb.setSpklbList(allSpkLbList(spkLbService,spkLb.getLbdm()));
			}else {
				continue;
			}
		}
		return spkLbList;
	}
	private List<SpkLb> oneSpkLbListByLbParent(SpkLbService spkLbService,String lbparent){
		return spkLbService.findByLbParent(lbparent);
	}
}
