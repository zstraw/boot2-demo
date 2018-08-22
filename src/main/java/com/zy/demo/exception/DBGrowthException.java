package com.zy.demo.exception;

import com.zy.demo.constant.GrowthErrorEnum;

public class DBGrowthException extends GrowthBaseException{
    public DBGrowthException(){
        super(GrowthErrorEnum.DB_ERROR.getErrno(),GrowthErrorEnum.DB_ERROR.getErrmsg());
    }
    public DBGrowthException(int errCode, String errMsg) {
        super(errCode, errMsg);
    }
    public DBGrowthException(GrowthErrorEnum err) {
        super(err.getErrno(), err.getErrmsg());
    }
}