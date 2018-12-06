package com.sun.controller.Backstage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sun.entity.HuoDong;
import com.sun.service.BackHuoDongService;
import com.sun.util.DateJsonValueProcessor;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/admin/backHuoDong")
public class BackHuoDongController {

	@Resource
	private BackHuoDongService backHuoDongService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
	}
	
	@RequestMapping("/list")
	public String list(Integer rows,Integer page,HuoDong huoDong,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		map.put("twoBarId", huoDong.getTwoBarId());
		map.put("searchName", StringUtil.formatLike(huoDong.getSearchName()));
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray=JSONArray.fromObject(backHuoDongService.list(map), jsonConfig);
		result.put("total", backHuoDongService.total(map));
		result.put("rows", jsonArray);
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(HuoDong huoDong,MultipartFile pic1,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		//上传文件路径
        String path = "D:\\image_xhyyPt\\huodong";
       
	    if(!pic1.isEmpty()) {
            //上传文件名,获得图片原本的名称
            String filename = UUID.randomUUID().toString()+"."+ pic1.getOriginalFilename().split("\\.")[1];
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            pic1.transferTo(new File(path + File.separator + filename));
            huoDong.setHomePageHuoDongCarouselTp("/image_xhyyPt/huodong/"+filename);
	    } 
	    boolean flag=false;
	    if(huoDong.getSfyx().equals("1")) {
	    	Map<String, Object> map=new HashMap<String, Object>();
	    	map.put("spkId", huoDong.getSpkId());
	    	map.put("sfyx", "1");
	    	HuoDong one = backHuoDongService.getOne(map);
	    	if(one!=null) {
	    		result.put("state", false);
		    	result.put("msg", "该商品正在参加活动！");
	    		ResponseUtil.write(result, response);
	    		return null;
	    	}
	    }
	    
	    if(huoDong.getId()==0) {
	    	flag = backHuoDongService.add(huoDong);
	    }else {
	    	flag = backHuoDongService.update(huoDong);
	    }
	    
	    if(flag) {
	    	result.put("state", true);
	    	result.put("msg", "保存成功");
	    }else {
	    	result.put("state", false);
	    	result.put("msg", "保存失败，请联系管理员！");
	    }
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(String ids, HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		boolean flag = backHuoDongService.delete(ids);
		 if(flag) {
		    	result.put("state", true);
		    	result.put("msg", "删除成功");
		    }else {
		    	result.put("state", false);
		    	result.put("msg", "删除失败，请联系管理员！");
		    }
		ResponseUtil.write(result, response);
		return null;
	}
}
