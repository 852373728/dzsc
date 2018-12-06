package com.sun.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.entity.Kh;
import com.sun.entity.UserCenter;
import com.sun.service.CollectionService;
import com.sun.service.FileService;
import com.sun.service.KhService;
import com.sun.service.RolesPermissionsService;
import com.sun.service.RolesService;
import com.sun.service.ShopCarService;
import com.sun.service.SpddService;
import com.sun.service.UserCenterService;
import com.sun.service.impl.BackShopCarMsgService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/userCenter")
public class UserCenterController {
	
	@Resource
	private UserCenterService userCenterService;
	@Resource
	private KhService khService;
	@Resource
	private ShopCarService shopCarService;
	@Resource
	private SpddService spddService;
	@Resource
	private CollectionService collectionService;
	@Resource
	private RolesPermissionsService rolesPermissionsService;
	@Resource
	private RolesService rolesService;
	@Resource
	private FileService fileService;
	@Resource
	private BackShopCarMsgService backShopCarMsgService;
	
	@RequestMapping("")
	public ModelAndView list(String cansu,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		Kh resultkh = khService.noHasKh(request);
		if(resultkh==null || StringUtil.isEmpty(cansu)) {
			mav.setViewName("redirect:/user/login.jsp");
			return mav;
		}
		List<Integer> byRolesName = rolesPermissionsService.byRolesName(resultkh.getSt_userclass());
		if(byRolesName==null || byRolesName.size()==0) {
			mav.setViewName("redirect:/user/login.jsp");
			return mav;
		}
		mav.addObject("userCenterList", userCenterService.listByParentId(byRolesName));
		Map<String, Object> map=new HashMap<String, Object>();
		if(resultkh.getZt().equals("1")) {
			mav.addObject("wz", "-90px");
			mav.addObject("rzmsg", "申请认证，请将相关证件资料的复印件邮寄到我们公司！");
			map.put("name", "企业认证");
			mav.addObject("userCenter", userCenterService.getOne(map));
			mav.addObject("userPage", "/user/enterpriseCertification.jsp");
		}else if(resultkh.getZt().equals("2")){
			if(cansu.equals("我的购物车")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				Map<String, Object> map1=new HashMap<String, Object>();
				map1.put("username", resultkh.getEmail());
				mav.addObject("shopCarList", shopCarService.list(map1,true,resultkh));
				mav.addObject("shopCarCxList", shopCarService.cxList(resultkh.getEmail()));
				mav.addObject("shopCarMsg", backShopCarMsgService.getOne(1));
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/shopCar.jsp");
			}else if(cansu.equals("订单查询")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/ddList.jsp");
			}else if(cansu.equals("我的收藏夹")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				mav.addObject("collectionList", collectionService.findByUserName(resultkh));
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/collection.jsp");
			}else if(cansu.equals("修改密码")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				mav.addObject("editUser", resultkh);
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/editPassword.jsp");
			}else if(cansu.equals("企业认证")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				mav.addObject("wz", "-210px");
				mav.addObject("rzmsg", "已通过审核！");
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/enterpriseCertification.jsp");
			}else if(cansu.equals("历史采购药品")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/historyGoods.jsp");
			}else if(cansu.equals("流向查询")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/lxcx.jsp");
			}else if(cansu.equals("角色权限管理")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				mav.addObject("rolesList", rolesService.list());
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/roles.jsp");
			}else if(cansu.equals("用户权限管理")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/userPermissions.jsp");
			}else if(cansu.equals("个人信息")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				mav.addObject("resultkh", resultkh);
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/lxfs.jsp");
			}else if(cansu.equals("文件上传")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/upload.jsp");
			}else if(cansu.equals("文件下载")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/download.jsp");
			}else if(cansu.equals("销售查询")) {
				List<String> listUserCenterName = userCenterService.listByID(byRolesName);
				if(!listUserCenterName.contains(cansu)) {
					mav.setViewName("redirect:/homePage.html");
					return mav;
				}
				map.put("name",cansu);
				mav.addObject("userCenter", userCenterService.getOne(map));
				mav.addObject("userPage", "/user/xsfx.jsp");
			}else {
				mav.setViewName("redirect:/homePage.html");
				return mav;
			}
		}
		mav.setViewName("user/userCenter");
		return mav;
	}
	
	@RequestMapping("/allPermissions")
	public String allPermissions(HttpServletResponse response,HttpServletRequest request,String name) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh(request);
		if(kh==null || StringUtil.isEmpty(name)) {
			ResponseUtil.write(result, response);
			return null;
		}
		List<Integer> userCenterIdList = rolesPermissionsService.byRolesName(name);
		List<UserCenter> list = userCenterService.listByParentId(null);
		List<Map<String, Object>> list1=new ArrayList<Map<String,Object>>();
		for (UserCenter userCenter : list) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("text", userCenter.getName());
			map.put("id", userCenter.getId());
			map.put("selectable", false);
			if(userCenterIdList.contains(userCenter.getId())) {
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("checked", true);
				map.put("state", hashMap);
			}
			List<UserCenter> erji = userCenter.getUserCenterList();
			List<Map<String, Object>> list2=new ArrayList<Map<String,Object>>();
			for (UserCenter userCenter2 : erji) {
				Map<String, Object> map2=new HashMap<String, Object>();
				map2.put("text", userCenter2.getName());
				map2.put("id", userCenter2.getId());
				if(userCenterIdList.contains(userCenter2.getId())) {
					HashMap<String, Object> hashMap = new HashMap<String, Object>();
					hashMap.put("checked", true);
					map2.put("state", hashMap);
				}
				list2.add(map2);
			}
			map.put("nodes", list2);
			list1.add(map);
		}
		result.put("list", list1);
		ResponseUtil.write(result, response);
		return null;
	}
	
}
