package com.rongzi.monitor.modules.apm.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Administrator
 * @Date: 2018/7/12 0012 16:23
 * @Description:
 */
public enum ExceptionLogStatusEnum {


    TOASSIGN(0, "待分配"),

    ASSIGNED(1, "已分配"),

    REPAIR(2, "待修复"),

    COMPLETED(3, "已完成");


    private static Map<Integer, String> data = new ConcurrentHashMap<Integer, String>();


    ExceptionLogStatusEnum(Integer statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }

    static {
        data.put(TOASSIGN.getStatusCode(), TOASSIGN.getMessage());
        data.put(ASSIGNED.getStatusCode(), ASSIGNED.getMessage());
        data.put(REPAIR.getStatusCode(), REPAIR.getMessage());
        data.put(COMPLETED.getStatusCode(), COMPLETED.getMessage());
    }

    private Integer statusCode;


    private String message;


    public Integer getStatusCode() {
        return statusCode;
    }


    public String getMessage() {
        return message;
    }


    public static String getStatusMessageByCode(int statusCode) {

        return ExceptionLogStatusEnum.data.get(statusCode);
    }

}
