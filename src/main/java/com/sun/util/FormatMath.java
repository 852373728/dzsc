package com.sun.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatMath {

	public static Integer format(String parameter,String format) {
		if(StringUtil.isEmpty(parameter)){
			parameter="1";
		}
		Pattern r = Pattern.compile(format);
		Matcher m = r.matcher(parameter);
		if(!m.matches()){
			parameter="1";
		}
		return Integer.parseInt(parameter);
	}
	
	public static Integer format(String parameter,String format,String math) {
		if(StringUtil.isEmpty(parameter)){
			parameter=math;
		}
		Pattern r = Pattern.compile(format);
		Matcher m = r.matcher(parameter);
		if(!m.matches()){
			parameter=math;
		}
		return Integer.parseInt(parameter);
	}
	
	
}
