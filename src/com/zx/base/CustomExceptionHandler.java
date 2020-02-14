package com.zx.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 自定义默认异常处理
 * <p/>
 * Created by zhangxin on 2015-07-28.
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private static Logger logger = LogManager.getLogger();

    @ExceptionHandler
    public String exceptionHandler(Exception ex){
        Exception e = new Exception(ex);
        String error = e + "\n";//异常错误信息
        StackTraceElement[] stacks = e.getCause().getStackTrace();
        for(StackTraceElement s : stacks){
            error += ("\tat " + s + "\n");
        }
        logger.error(error);
        return "common/error";
    }
}
