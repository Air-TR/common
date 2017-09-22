package com.tr.common.utils.result;

public enum ResultEnum {

    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    
    PARAMETER_NULL(2, "参数为空"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
