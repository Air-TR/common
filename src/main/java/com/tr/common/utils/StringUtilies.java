package com.tr.common.utils;

import java.util.Formatter;
import java.util.List;
import java.util.Random;

/**
 * String工具类
 * 
 * 1.获取一定长度的随机字符串（大小写字母和数字组成）
 * 2.字符串是否为NULL或空
 * 3.连接数组中的字符串（按指定分隔符）
 * 4.string的格式化：
 * 		传参示例："Hello, %s, %s", "A", "B"
 * 		输出示例：Hello, A, B
 * 5.将list转换为逗号分隔的字符串
 * 6.若首字母为字母，返回字符串首字母大写
 * 
 * @author taorun
 * @date 2017年9月21日 下午2:14:49
 *
 */
public class StringUtilies {

	/**
	 * 获取一定长度的随机字符串（大小写字母和数字组成）
	 * 
	 * @param length 指定字符串长度
	 * @return 一定长度的字符串
	 */
	public static String getRandomStringByLength(int length) {
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 字符串是否为NULL或空
	 *
	 * @param s
	 * @return
	 */
	public static boolean isNullOrEmpty(String s) {
		boolean y = false;
		if (s == null) {
			y = true;
		} else if (s.trim().equals("")) {
			y = true;
		}
		return y;
	}

	/**
	 * 连接数组中的字符串（按指定分隔符）
	 *
	 * @param array
	 * @param split
	 * @return
	 */
	public static String conArray(String[] array, String split) {
		StringBuilder str = new StringBuilder();
		if (array != null) {
			for (String a : array) {
				str.append(split).append(a);
			}
		}
		return str.deleteCharAt(0).toString();
	}

	/**
	 * string的格式化
	 * 传参示例："Hello, %s, %s", "A", "B"
	 * 输出示例：Hello, A, B
	 * 
	 * @param format
	 * @param args
	 * @return
	 */
	public static String format(String format, Object... args) {
		try (Formatter fmt = new Formatter();) {
			return fmt.format(format, args).toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将list转换为逗号分隔的字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String listToString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1) {
					sb.append(list.get(i) + ",");
				} else {
					sb.append(list.get(i));
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 若首字母为字母，返回字符串首字母大写
	 * <p>
	 * Capitalizes a String changing the first character to title case as per
	 * {@link Character#toTitleCase(char)}. No other characters are changed.
	 * </p>
	 *
	 * <p>
	 * For a word based algorithm, see
	 * {@link org.apache.commons.lang3.text.WordUtils#capitalize(String)}. A
	 * {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.capitalize(null)  = null
	 * StringUtils.capitalize("")    = ""
	 * StringUtils.capitalize("cat") = "Cat"
	 * StringUtils.capitalize("cAt") = "CAt"
	 * StringUtils.capitalize("'cat'") = "'cat'"
	 * </pre>
	 *
	 * @param str
	 *            the String to capitalize, may be null
	 * @return the capitalized String, {@code null} if null String input
	 * @see org.apache.commons.lang3.text.WordUtils#capitalize(String)
	 * @see #uncapitalize(String)
	 * @since 2.0
	 */
	public static String capitalize(final String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}

		final char firstChar = str.charAt(0);
		final char newChar = Character.toTitleCase(firstChar);
		if (firstChar == newChar) {
			return str;
		}

		char[] newChars = new char[strLen];
		newChars[0] = newChar;
		str.getChars(1, strLen, newChars, 1);
		return String.valueOf(newChars);
	}

}
