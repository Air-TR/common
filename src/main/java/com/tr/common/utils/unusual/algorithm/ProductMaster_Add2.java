package com.tr.common.utils.unusual.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 逻辑：添加产品清单多选情况。
 * 
 * @author taorun
 * @date 2017年9月19日 上午11:28:59
 *
 */
public class ProductMaster_Add2 {

	public static String onePat = ",";
	public static String twoPat = "[+]";
	public static final List<String> result = new ArrayList<String>();

	public static List<String> patternStringToList(String str, String pattern) {
		List<String> list = new ArrayList<String>();
		for (String g : str.split(pattern))
			list.add(g);
		return list;
	}

	public static void main(String[] args) {

		String inString="10+11+12,20+21+22,30+31+32,40+41+42,50+51+52,60+61+62+63";
//		String inString = "10,20,30+31+32,40,50+55";
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> strRes = new ArrayList<String>();
		List<String> resR = new ArrayList<String>();
		for (String g : patternStringToList(inString, onePat)) {
			result.add(patternStringToList(g, twoPat));
		}
		for (String g : result.get(0)) {
			strRes.add(g);
		}
		List<String> preList = new ArrayList<String>();
		for (String gg : strRes) {
			preList.add(gg);
		}
		for (int i = 0; i < result.size(); i++) {
			for (String sg : result.get(i)) {
				for (String strr : strRes) {
					if (i == 0) {

					} else {
						if (strr.split(",").length == i) {
							if (i == result.size() - 1) {
								resR.add(strr + "," + sg);
							} else {
								preList.add(strr + "," + sg);
							}
						}
					}
				}
				strRes = new ArrayList<String>();
				for (String f : preList) {
					strRes.add(f);
				}
			}
		}
		for (int t = 0; t < resR.size(); t++) {
			System.out.println("第" + (t + 1) + "结果:" + resR.get(t));
		}

	}

}
