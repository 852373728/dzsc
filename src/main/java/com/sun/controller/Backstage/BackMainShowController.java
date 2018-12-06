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

import com.sun.entity.MainShow;
import com.sun.service.BackMainShowService;
import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/backMainShow")
public class BackMainShowController {

	@Resource
	private BackMainShowService backMainShowService;
	
	@RequestMapping("/list")
	public String list(Integer rows,Integer page,MainShow mainShow,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("size", rows);
		map.put("sywzdm", mainShow.getSywzdm());
		map.put("searchName", StringUtil.formatLike(mainShow.getSearchName()));
		result.put("total", backMainShowService.total(map));
		result.put("rows", backMainShowService.list(map));
		ResponseUtil.write(result, response);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(MainShow mainShow,MultipartFile pic1,HttpServletResponse response) throws Exception{
		JSONObject result=new JSONObject();
		//�ϴ��ļ�·��
        String path = "D:\\image_xhyyPt\\mainShow";
        switch (Integer.parseInt(mainShow.getSywzdm())) {
		case 1:
			mainShow.setSywzmc("�ȵ�");
			break;
		case 2:
			mainShow.setSywzmc("�ֲ�");
			break;
		case 3:
			mainShow.setSywzmc("����Ȥ");
			break;
		case 4:
			mainShow.setSywzmc("����ͼƬ");
			break;
		default:
			break;
		}
        
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
            mainShow.setTplj("/image_xhyyPt/mainShow/"+filename);
	    } 
	    boolean flag=false;
	    if(mainShow.getId()==0) {
	    	flag = backMainShowService.add(mainShow);
	    }else {
	    	flag = backMainShowService.update(mainShow);
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
		boolean flag = backMainShowService.delete(ids);
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
