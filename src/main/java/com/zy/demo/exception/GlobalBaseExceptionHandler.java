package com.zy.demo.exception;

import com.alibaba.fastjson.JSONObject;
import com.zy.demo.constant.GrowthErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fivebit on 2017/11/27.
 */
@ControllerAdvice
public class GlobalBaseExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalBaseExceptionHandler.class);

    @ExceptionHandler(value = GrowthBaseException.class)
    @ResponseBody
    public JSONObject jsonErrorHandler(HttpServletRequest req, GrowthBaseException e) throws Exception {
        return e.toJson();
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public JSONObject notValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        logger.error("notValidExceptionHandler:{}", e.getMessage());
        JSONObject ret = new JSONObject();
        ret.put("errno", GrowthErrorEnum.PARAM_ERROR.getErrno());
        ret.put("errmsg", GrowthErrorEnum.PARAM_ERROR.getErrmsg());
        ret.put("data", e.getBindingResult().getFieldError().getField()+" "+e.getBindingResult().getFieldError().getDefaultMessage());
        return ret;
    }
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public JSONObject httpMessageNotReadableExceptionHandler(HttpServletRequest req, HttpMessageNotReadableException e) {
        logger.error("notValidExceptionHandler:{}", e.getMessage());
        JSONObject ret = new JSONObject();
        ret.put("errno", GrowthErrorEnum.PARAM_ERROR.getErrno());
        ret.put("errmsg", GrowthErrorEnum.PARAM_ERROR.getErrmsg());
        return ret;
    }
}
