package com.sun.controller.Backstage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.entity.ThreeBar;
import com.sun.service.BackThreeBarService;
import com.sun.util.DateJsonValueProcessor;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/admin/backThreeBar")
public class BackThreeBarController {
	
	@Resource
	private BackThreeBarService backThreeBarService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
	}

	@RequestMapping("/list")
	public String list(Integer rows,Integer page,ThreeBar threeBar,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		map.put("name", StringUtil.formatLike(threeBar.getName()));
		map.put("twoBarId", threeBar.getTwoBarId());
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray=JSONArray.fromObject(backThreeBarService.list(map), jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", backThreeBarService.total(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(ThreeBar threeBar,MultipartFile pic1,HttpServletResponse response) throws Exception{
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
            threeBar.setCarouselTplj("/image_xhyyPt/huodong/"+filename);
	    } 
	    boolean flag=false;
	    if(threeBar.getId()==0) {
	    	flag = backThreeBarService.add(threeBar);
	    }else {
	    	flag = backThreeBarService.update(threeBar);
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
		boolean flag = backThreeBarService.delete(ids);
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
	
	@RequestMapping("/combobox")
	public String combobox(@RequestParam(required=false,value="twoBarId")Integer twoBarId,HttpServletResponse response) throws Exception{
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("id", 0);
		jsonObject.put("name", "请选择");
		jsonArray.add(jsonObject);
		List<ThreeBar> listByTwoBar = backThreeBarService.listByTwoBar(twoBarId);
		JSONArray rows = JSONArray.fromObject(listByTwoBar);
		jsonArray.addAll(rows);
		ResponseUtil.write(jsonArray,response);
		return null;
	}
	
}
