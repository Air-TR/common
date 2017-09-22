package com.tr.common.utils.unusual;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class MD5_BASE64Encoder {
	
	public static String EncoderByMd5(String password) {
		try {
			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			// 加密后的字符串
			String ciphertext = base64en.encode(md5.digest(password.getBytes("utf-8")));
			return ciphertext;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return password;
	}

	public static boolean checkpassword(String password, String ciphertext) {
		if (EncoderByMd5(password).equals(ciphertext))
			return true;
		else
			return false;
	}

}
