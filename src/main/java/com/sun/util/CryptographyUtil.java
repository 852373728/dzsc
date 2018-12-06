package com.sun.util;

import org.apache.shiro.crypto.hash.Md5Hash;


public class CryptographyUtil {

	
	/**
	 * Md5º”√‹
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	
	public static void main(String[] args) {
		String password="xhyy&7133";
		String md5 = md5(password, "sun");
		System.out.println(md5);
	}
}
