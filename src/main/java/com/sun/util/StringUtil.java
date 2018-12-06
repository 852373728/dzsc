package com.sun.util;

import java.util.ArrayList;
import java.util.List;


public class StringUtil {

	
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static boolean isNotEmpty(String str){
		if((str!=null)&&!"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static String formatLike(String str){
		if(isNotEmpty(str)){
			return "%"+str+"%";
		}else{
			return null;
		}
	}
	
	
	public static List<String> filterWhite(List<String> list){
		List<String> resultList=new ArrayList<String>();
		for(String l:list){
			if(isNotEmpty(l)){
				resultList.add(l);
			}
		}
		return resultList;
	}
	
	
	/**
	 * 生成四位编号
	 * @param code
	 * @return
	 */
	public static String formatCode(String code){
		int length=code.length();
		Integer num=Integer.parseInt(code.substring(length-4,length))+1;
		String codeNum=num.toString();
		int codeLength=codeNum.length();
		for(int i=4;i>codeLength;i--){
			codeNum="0"+codeNum;
		}
		return codeNum;
	}

}
