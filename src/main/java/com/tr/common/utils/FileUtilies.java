package com.tr.common.utils;

import java.io.File;
import java.io.InputStream;

/**
 * 文件操作工具类
 * 
 * 1.获取文件的扩展名
 * 2.去除文件的扩展名，获得文件名
 * 3.获取项目路径的上一级完整路径
 * 4.判断路径是否存在，不存在则创建
 * 5.获取classpath下单文件流 filepath: /a/b/c
 * 6.替换路径中 '\\' 为 '/'
 * 7.文件删除
 * 
 * @author taorun
 * @date 2017年12月12日 上午10:34:46
 *
 */
public class FileUtilies {

	/**
	 * 获取文件的扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtensionName(String filename) {
		int dot = filename.lastIndexOf('.');
		if ((dot > -1) && (dot < (filename.length() - 1))) {
			return filename.substring(dot + 1);
		}
		return filename;
	}

	/**
	 * 去除文件的扩展名，获得文件名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getFileName(String filename) {
		int dot = filename.lastIndexOf('.');
		if ((dot > -1) && (dot < (filename.length() - 1))) {
			return filename.substring(0, dot);
		}
		return filename;
	}

	/**
	 * 获取项目路径的上一级完整路径
	 * 
	 * @param filename
	 * @return
	 */
	public static String getUpperPath(String filename) {
		int dot = filename.lastIndexOf('/');
		if ((dot > -1) && (dot < (filename.length() - 1))) {
			return filename.substring(0, dot);
		}
		return filename;
	}

	/**
	 * 判断路径是否存在，不存在则创建
	 * 
	 * @param path
	 * @return
	 */
	public static boolean checkPathExist(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return file.mkdirs();
		}
		return true;
	}

	/**
	 * 获取classpath下单文件流 filepath: /a/b/c
	 * 
	 * @param filepath
	 * @return
	 */
	public static InputStream getClassPathFile(String filepath) {
		filepath = fixPath(filepath);
		if ("/".equals(filepath.substring(0, 1))) {
			filepath = filepath.substring(1, filepath.length());
		}
		InputStream inputStream = FileUtilies.class.getResourceAsStream(filepath);
		return inputStream;
	}

	/**
	 * 替换路径中 '\\' 为 '/'
	 * 
	 * @param path
	 * @return
	 */
	public static String fixPath(String path) {
		return path.replace('\\', '/');
	}

	/**
	 * 文件删除
	 * 
	 * @param path
	 */
	public static void deleteFile(String path) {
		File file = new File(path);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

}
