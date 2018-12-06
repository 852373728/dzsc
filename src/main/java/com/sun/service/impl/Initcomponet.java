package com.sun.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.sun.entity.MainShow;
import com.sun.entity.SpkLb;
import com.sun.service.MainShowService;
import com.sun.service.NavigationBarService;
import com.sun.service.SpkLbService;


@Component
public class Initcomponet implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		MainShowService mainShowService = (MainShowService) applicationContext.getBean("mainShowService");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("sywzdm", "1");
		map.put("showSize", 6);
		List<MainShow> hotList = mainShowService.findListBySywzdm(map);
		application.setAttribute("hotList", hotList);
		
		NavigationBarService navigationBarService = (NavigationBarService) applicationContext.getBean("navigationBarService");
		application.setAttribute("navigationBarList", navigationBarService.finList());
		
		SpkLbService spkLbService = (SpkLbService) applicationContext.getBean("spkLbService");
		application.setAttribute("allSpkLbByLbparent", allSpkLbList(spkLbService, "z"));
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
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
