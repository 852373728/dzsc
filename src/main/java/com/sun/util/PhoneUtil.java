package com.sun.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PhoneUtil {

	public static InputStream message(String mobile,int mobile_code) {
		try {
			String postUrl = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
			String account = "C63397647"; //查看用户名是登录用户中心->验证码短信->产品总览->APIID
			String password = "4805f5e4627940da57b189c8eff037c2";  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
			String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
			URL url = new URL(postUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);//允许连接提交信息
			connection.setRequestMethod("POST");//网页提交方式“GET”、“POST”
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Connection", "Keep-Alive");
			StringBuffer sb = new StringBuffer();
			sb.append("account="+account);
			sb.append("&password="+password);
			sb.append("&mobile="+mobile);
			sb.append("&content="+content);
			OutputStream os = connection.getOutputStream();
			os.write(sb.toString().getBytes());
			os.close();
			return connection.getInputStream();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public static InputStream message1(String mobile,String param) {
		try {
			String postUrl = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
			String account = "C80112931"; //查看用户名是登录用户中心->验证码短信->产品总览->APIID
			String password = "9ba07ffd72db106c88492db0a3642a60";  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
			String content = new String(param);
			URL url = new URL(postUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);//允许连接提交信息
			connection.setRequestMethod("POST");//网页提交方式“GET”、“POST”
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Connection", "Keep-Alive");
			StringBuffer sb = new StringBuffer();
			sb.append("account="+account);
			sb.append("&password="+password);
			sb.append("&mobile="+mobile);
			sb.append("&content="+content);
			OutputStream os = connection.getOutputStream();
			os.write(sb.toString().getBytes());
			os.close();
			return connection.getInputStream();
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
