package com.tr.common.utils.unusual.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 逻辑：添加产品清单多选情况。
 * 
 * @author taorun
 * @date 2017年9月19日 上午11:28:13
 *
 */
public class ProductMaster_Add1 {

	public static void main(String[] args) {

//		String matchingConditionIds = "10+11+12,20+21+22,30+31+32,40+41+42,50+51+52,60+61+62+63";
		String matchingConditionIds = "10+11,20,30+31,40,50+51+52,60";
		String[] ids = matchingConditionIds.split(","); // 同级id
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < ids.length; i++) {
			String[] ids2 = ids[i].split("[+]");
			if (i == 0) {
				for (String string : ids2) {
					list.add(string);
				}
			} else {
				if (ids2.length == 1 && i != 0) {
					for (int j = 0; j < list.size(); j++) {
						list.set(j, list.get(j) + "," + ids2[0]);
					}
				} else {
					List<String> l = new ArrayList<String>(list); // 复制一份当前list
					list.removeAll(list); // 原list清空
					for (int j = 0; j < ids2.length; j++) {
						for (int k = 0; k < l.size(); k++) {
							list.add(l.get(k) + "," + ids2[j]);
						}
					}
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println("第" + (i + 1) + "种结果：" + list.get(i));
		}

	}

}
