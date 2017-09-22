package com.tr.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	
	public static String md5(String password) {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(password.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			String ciphertext = new BigInteger(1, md.digest()).toString(16);
			return ciphertext;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return password;
    }
	
	public static boolean check(String password, String ciphertext) {
		if (md5(password).equals(ciphertext))
			return true;
		else
			return false;
	}

}
