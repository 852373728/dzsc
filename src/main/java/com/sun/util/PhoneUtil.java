package com.sun.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PhoneUtil {

	public static InputStream message(String mobile,int mobile_code) {
		try {
			String postUrl = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
			String account = "C63397647"; //�鿴�û����ǵ�¼�û�����->��֤�����->��Ʒ����->APIID
			String password = "4805f5e4627940da57b189c8eff037c2";  //�鿴�������¼�û�����->��֤�����->��Ʒ����->APIKEY
			String content = new String("������֤���ǣ�" + mobile_code + "���벻Ҫ����֤��й¶�������ˡ�");
			URL url = new URL(postUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);//���������ύ��Ϣ
			connection.setRequestMethod("POST");//��ҳ�ύ��ʽ��GET������POST��
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
			String account = "C80112931"; //�鿴�û����ǵ�¼�û�����->��֤�����->��Ʒ����->APIID
			String password = "9ba07ffd72db106c88492db0a3642a60";  //�鿴�������¼�û�����->��֤�����->��Ʒ����->APIKEY
			String content = new String(param);
			URL url = new URL(postUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);//���������ύ��Ϣ
			connection.setRequestMethod("POST");//��ҳ�ύ��ʽ��GET������POST��
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
