package com.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.util.ResponseUtil;
import com.sun.util.StringUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.awt.image.BufferedImage;  

@Controller
public class PictureCorrection {
	
	@RequestMapping("/picture")
	public String picture(String src,String width,String height,HttpServletResponse response,HttpServletRequest request) throws Exception{
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		if(StringUtil.isEmpty(src)) {
			src="default_800x800.jpg";
		}
		String localhostPaht=requestURL.substring(0, requestURL.indexOf(requestURI))+"/files/"+src;
		URL url=new URL(localhostPaht);  
		BufferedImage im = ImageIO.read(url.openStream());  
		BufferedImage result = new BufferedImage(Integer.parseInt(width),Integer.parseInt(height),  
                 BufferedImage.TYPE_INT_RGB); 
		result.getGraphics().drawImage(  
                im.getScaledInstance(Integer.parseInt(width), Integer.parseInt(height),  
                        java.awt.Image.SCALE_SMOOTH), 0, 0, null);
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
		ImageIO.write(result, "JPG", out); 
		byte[] b = out.toByteArray(); 
		ResponseUtil.writeTp(b, response);
		return null;
	}
	
	
}
