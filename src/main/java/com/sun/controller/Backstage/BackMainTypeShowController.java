package com.sun.controller.Backstage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sun.entity.MainTypeShow;
import com.sun.service.BackMainTypeShowService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/backMainTypeShow")
public class BackMainTypeShowController {

	@Resource
	private BackMainTypeShowService backMainTypeShowService;
	
	@RequestMapping("/list")
	public String list(Integer rows,Integer page,MainTypeShow mainTypeShow,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		map.put("homePageshow", mainTypeShow.getHomePageshow());
		map.put("searchName", StringUtil.formatLike(mainTypeShow.getSearchName()));
		result.put("total", backMainTypeShowService.total(map));
		result.put("rows", backMainTypeShowService.list(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(MainTypeShow mainTypeShow,MultipartFile pic1,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		//上传文件路径
        String path = "D:\\image_xhyyPt\\mainShow";
        
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
            mainTypeShow.setOnePicTplj("/image_xhyyPt/mainShow/"+filename);
	    } 
	    boolean flag=false;
	    if(mainTypeShow.getId()==0) {
	    	flag = backMainTypeShowService.add(mainTypeShow);
	    }else {
	    	flag = backMainTypeShowService.update(mainTypeShow);
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
		boolean flag = backMainTypeShowService.delete(ids);
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
