package com.sun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.entity.Kh;
import com.sun.service.FileService;
import com.sun.service.KhService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;
import com.sun.util.Zz;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/fileOpre")
public class FileController {

	@Resource
	private FileService fileService;
	@Resource
	private KhService khService;
	
	@RequestMapping("/list")
	public String list(HttpServletResponse response,HttpServletRequest request,String page,String size,String searchName) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh(request);
		if(kh==null || !kh.getZt().equals("2") || !Zz.num(size) ||!Zz.num(page)) {
			ResponseUtil.write(result, response);
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("size", size);
		map.put("page", page);
		map.put("searchName", StringUtil.formatLike(searchName));
		
		if(kh.getSt_userclass().equals("管理员")) {
			result.put("guanliyuan", true);
		}
		result.put("rows", fileService.list(map));
		result.put("total", fileService.total(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletResponse response,HttpServletRequest request,String id) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh(request);
		if(kh==null || !kh.getZt().equals("2") || !Zz.num(id) || !kh.getSt_userclass().equals("管理员") ) {
			ResponseUtil.write(result, response);
			return null;
		}
		boolean delete = fileService.delete(Integer.parseInt(id));
		result.put("state", delete);
		result.put("msg", "删除成功");
		ResponseUtil.write(result, response);
		return null;
	}
	
	
}
