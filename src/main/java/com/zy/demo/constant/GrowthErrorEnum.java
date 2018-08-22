package com.zy.demo.constant;

/**
 * Created by chenhui on 2018/5/4.
 */
public enum GrowthErrorEnum {

    SUCC(0, "成功"),

    NET_ERROR(101, "网络异常"),
    PARAM_ERROR(102, "参数错误"),
    DATA_ERROR(103, "数据为空"),

    DB_ERROR(200,"数据库出错") ,
    DB_SEARCH_ERROR(204, "数据库查询出错"),
    DB_INSERT_ERROR(305, "数据库插入出错"),
    DB_UPDATE_ERROR(406, "数据库更新出错"),

    USER_FILTER(1007, "用户被过滤"),
    ACTIVITY_FINISHED(1008, "活动已过期"),
    START_ACTIVITY_ERROR(1009, "启动活动失败"),
    STOP_ACTIVITY_ERROR(1010, "停止活动失败"),
    ACTIVITY_NOT_OPEN(1011, "活动未开始"),
    ACTIVITY_NOT_EXIST(1012, "活动不存在"),
    ACTIVITY_DATE_NULL(1013, "活动日期为空"),
    ACTIVITY_ALREADY_RUN(1014, "活动已经运行"),
    ACTIVITY_ALREADY_STOP(1015, "活动已经停止"),

    NO_AVAILABLE_MQ_ERROR(1101, "无可用队列")
    ;

    GrowthErrorEnum(int c, String m) {
        this.errno = c;
        this.errmsg = m;
    }

    private  int errno;

    private String errmsg;

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
}
