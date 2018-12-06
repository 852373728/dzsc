package com.sun.util;

import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


public class ResponseUtil {

	public static void write(Object o,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
	
	public static void writeTp(byte[] o,HttpServletResponse response)throws Exception{
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		out.write(o);
		out.close();
		out.flush();
	}
}
