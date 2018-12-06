package com.sun.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author sunqilin
 *
 */
public class Zz {

	/**
	 * 手机正则
	 * @param param,要验证的参数
	 * @param regex，正则规范
	 * @param length，要规定参数长度
	 * @return
	 */
	public static boolean yz(String phone) {
	        String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
	        if(phone.length() != 11){
	            return false;
	        }else{
	            Pattern p = Pattern.compile(regex);
	            Matcher m = p.matcher(phone);
	            return m.matches();
	        }
	}
	
	public static boolean pwd(String param) {
		String regex = "^[a-zA-Z0-9]{1,10}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(param);
        return m.matches();
	}
	
	public static int math(String param) {
		String regex = "^[0-9]{1,}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(param);
        if(m.matches()) {
        	return Integer.parseInt(param);
        }else {
        	return 1;
        }
	}
	
	public static boolean num(String param) {
		String regex = "^\\d{1,}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(param);
        return m.matches();
	}
	
	public static boolean numSz(String param) {
		String regex = "^\\d{1,}";
		String[] split = param.split(",");
		for (String num : split) {
			 Pattern p = Pattern.compile(regex);
		     Matcher m = p.matcher(num);
		     if(m.matches()==false) {
		    	 return false;
		     }
		}
		return true;
	}
	
	
}
