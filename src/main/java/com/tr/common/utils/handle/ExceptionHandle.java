//package com.tr.common.utils.handle;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.tr.common.utils.exception.MyException;
//import com.tr.common.utils.result.Result;
//import com.tr.common.utils.result.ResultEnum;
//
///**
// * 统一异常处理
// * 
// * @author taorun
// * @date 2017年9月22日 下午6:14:06
// *
// */
//
//@ControllerAdvice
//public class ExceptionHandle {
//
//    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result handle(Exception e) {
//        if (e instanceof MyException) {
//            MyException myException = (MyException) e;
//            return Result.fail(myException.getMessage());
//        } else {
//            logger.error("[系统异常]", e);
//            return Result.fail(e.getMessage());
//        }
//    }
//
//}
