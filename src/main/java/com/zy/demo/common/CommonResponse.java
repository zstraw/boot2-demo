package com.zy.demo.common;

import com.zy.demo.constant.GrowthErrorEnum;

import java.io.Serializable;

public class CommonResponse implements Serializable {
    private static final long serialVersionUID = -3611620980255512836L;

    private int errno;

    private String errmsg;

    private Object data;

    public CommonResponse() {
    }

    public CommonResponse(GrowthErrorEnum errorEnum) {
        this.errmsg = errorEnum.getErrmsg();
        this.errno = errorEnum.getErrno();
    }

    public CommonResponse(Object data) {
        this.data = data;
    }

    public void fillErrInfo(GrowthErrorEnum errorEnum){
        this.errmsg = errorEnum.getErrmsg();
        this.errno = errorEnum.getErrno();
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
