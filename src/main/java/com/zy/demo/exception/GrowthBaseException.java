package com.zy.demo.exception;

import com.alibaba.fastjson.JSONObject;
import com.zy.demo.constant.GrowthErrorEnum;

/**
 * @author
 */
public class GrowthBaseException extends RuntimeException{
    public int errno;

    public String errmsg;

    public GrowthBaseException(int errCode, String errMsg) {
        super(errMsg);
        this.errno = errCode;
        this.errmsg = errMsg;
    }
    public GrowthBaseException(GrowthErrorEnum errorEnum){
        super(errorEnum.getErrmsg());
        this.errno = errorEnum.getErrno();
        this.errmsg = errorEnum.getErrmsg();
    }
    public JSONObject toJson(){
        JSONObject ret = new JSONObject();
        ret.put("errno",errno);
        ret.put("errmsg",errmsg);
        ret.put("data",null);
        return ret;
    }
}
