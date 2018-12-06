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
		//�ϴ��ļ�·��
        String path = "D:\\image_xhyyPt\\mainShow";
        
	    if(!pic1.isEmpty()) {
            //�ϴ��ļ���,���ͼƬԭ��������
            String filename = UUID.randomUUID().toString()+"."+ pic1.getOriginalFilename().split("\\.")[1];
            File filepath = new File(path,filename);
            //�ж�·���Ƿ���ڣ���������ھʹ���һ��
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //���ϴ��ļ����浽һ��Ŀ���ļ�����
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
	    	result.put("msg", "����ɹ�");
	    }else {
	    	result.put("state", false);
	    	result.put("msg", "����ʧ�ܣ�����ϵ����Ա��");
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
		    	result.put("msg", "ɾ���ɹ�");
		    }else {
		    	result.put("state", false);
		    	result.put("msg", "ɾ��ʧ�ܣ�����ϵ����Ա��");
		    }
		ResponseUtil.write(result, response);
		return null;
	}
}
