package com.tr.common.utils;

import com.tr.common.utils.exception.MyException;
import com.tr.common.utils.result.ResultEnum;

/**
 * 判断非空工具类
 * 
 * 1.判断非空
 * 2.判断参数是否全部为空
 * 
 * @author taorun
 * @date 2017年9月21日 上午11:46:57
 *
 */
public final class ParamCheckUtils {
	
    /**
     * 判断非空
     * 
     * @param objects
     * @param params
     * @throws MyException
     */
    public static void notNull(Object[] objects, String[] params) throws MyException {
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            if (object instanceof String && isNullOrEmpty((String) object)) {
                throw new MyException(ResultEnum.PARAMETER_NULL, params[i] + "不能为空");
            } else if (!(object instanceof String) && object == null) {
                throw new MyException(ResultEnum.PARAMETER_NULL, params[i] + "不能为空");
            }
        }
    }
    
    /**
     * 判断参数是否全部为空
     * 
     * @param objects
     * @throws MyException
     */
    public static void notAllNull(Object[] objects) throws MyException {
        if ((objects == null) || (objects.length == 0)) {
            return;
        }

        int num = 0;
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            if (object instanceof String && isNullOrEmpty((String) object)) {
                num++;
            } else if (!(object instanceof String) && object == null) {
                num++;
            }
        }
        if (num == objects.length) {
            throw new MyException(ResultEnum.PARAMETER_NULL);
        }
    }
    
    
    //---------------------------------- 额外方法 ----------------------------------
    
    /**
	 * 字符串是否为NULL或空
	 * 摘取自StringUtils工具类
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
    
}
