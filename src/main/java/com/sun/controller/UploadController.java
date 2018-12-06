package com.sun.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.service.FileService;
import com.sun.service.KhService;
import com.sun.util.ResponseUtil;
import com.sun.entity.Kh;
import com.sun.entity.T_File;

import net.sf.json.JSONObject;

@Controller
public class UploadController {
	
	@Resource
	private FileService fileService;
	@Resource
	private KhService khService;

	@RequestMapping(value = "/uploadTrainProduct", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    public String uploadTrainProduct(@RequestParam(value = "file") MultipartFile[] files,HttpServletResponse response,HttpServletRequest request) throws Exception {
		JSONObject result=new JSONObject();
		Kh kh = khService.noHasKh(request);
		if(kh==null) {
			 ResponseUtil.write(result, response);
			return null;
		}
		for (MultipartFile file : files) {    //循环保存文件
                String fileName = uploadFile(file);
                String name = file.getOriginalFilename().split("\\.")[0];
                fileService.add(new T_File(name, fileName));
        }
        result.put("status", true);
        result.put("msg", "上传成功");
        ResponseUtil.write(result, response);
		return null;
	}
 
    private String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String path="d:/image_xhyyPt/文件";//设置文件保存路径
//      File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
        File tempFile = new File(path, String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {//创建文件夹
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return "/image_xhyyPt/文件/" + tempFile.getName();
    }

}
