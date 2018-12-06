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

import com.sun.entity.TuiJian;
import com.sun.service.BackTuiJianService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/BackTuiJian")
public class BackTuiJianController {
	
	@Resource
	private BackTuiJianService backTuiJianService;

	@RequestMapping("/list")
	public String list(Integer rows,Integer page,TuiJian tuijian,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		map.put("twobarName", tuijian.getTwobarName());
		map.put("searchName", StringUtil.formatLike(tuijian.getSearchName()));
		result.put("total", backTuiJianService.total(map));
		result.put("rows", backTuiJianService.list(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(TuiJian tuiJian,MultipartFile pic1,MultipartFile pic2,MultipartFile pic3,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		//�ϴ��ļ�·��
        String path = "D:\\image_xhyyPt\\tuijian";
       
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
            tuiJian.setSptpljLeft("/image_xhyyPt/tuijian/"+filename);
	    } 
	    if(!pic3.isEmpty()) {
            //�ϴ��ļ���,���ͼƬԭ��������
            String filename = UUID.randomUUID().toString()+"."+ pic3.getOriginalFilename().split("\\.")[1];
            File filepath = new File(path,filename);
            //�ж�·���Ƿ���ڣ���������ھʹ���һ��
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //���ϴ��ļ����浽һ��Ŀ���ļ�����
            pic3.transferTo(new File(path + File.separator + filename));
            tuiJian.setHomePageTuijianCarouselTp("/image_xhyyPt/tuijian/"+filename);
	    } 
	    boolean flag = backTuiJianService.update(tuiJian);
	   /* if(tuiJian.getId()==0) {
	    	flag = backTuiJianService.add(tuiJian);
	    }else {
	    	flag = backTuiJianService.update(tuiJian);
	    }*/
	    
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
		boolean flag = backTuiJianService.delete(ids);
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
