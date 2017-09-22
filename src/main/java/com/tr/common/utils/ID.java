package com.tr.common.utils;

import java.util.UUID;

/**
 * 生成唯一id
 * 
 * @author taorun
 * @date 2017年9月14日 下午4:06:53
 *
 */

public class ID {
	
	public static void main(String[] args) {
		System.out.println(uuid());
	}
	
	public static final String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
