package com.tr.common.utils.exception;

import com.tr.common.utils.result.ResultEnum;

/**
 * 异常处理
 * 
 * @author taorun
 * @date 2017年9月21日 下午2:04:03
 *
 */
public class MyException extends RuntimeException {

	private static final long serialVersionUID = -5885257209681964022L;
	
	private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    
    public MyException(String message) {
	    	super(message);
	    	this.code = ResultEnum.FAIL.getCode();
    }
    
    public MyException(ResultEnum resultEnum, String message) {
	    	super(message);
	    	this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
