package com.tr.common.utils.unusual.algorithm;

/**
 * 数组全排列算法
 * 
 * @author taorun
 * @date 2017年6月8日 下午3:31:00
 *
 */
public class Permutate_Array {
	
	public static int total = 0;
	
	public static void main(String[] args) {
		String[] str = { "A", "B", "C" };
		arrange(str, 0, str.length);
		System.out.println(total);
	}

	public static void swap(String[] arr, int i, int j) {
		String temp = new String();
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void arrange(String[] arr, int st, int len) {
		if (st == len - 1) {
			for (int i = 0; i < len; i++) {
				System.out.print(arr[i] + "  ");
			}
			System.out.println();
			total++;
		} else {
			for (int i = st; i < len; i++) {
				swap(arr, st, i);
				arrange(arr, st + 1, len);
				swap(arr, st, i);
			}
		}
	}

}
