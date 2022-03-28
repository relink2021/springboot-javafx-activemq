package com.relink.chat.core.util;

import java.util.HashMap;
import java.util.Map;

public enum ReturnNo {
    OK(0, "成功"),
    LOGIN_IS_FAILED(101, "用户登录失败"),
    USER_IS_EXIST(102, "用户已存在"),
    PWD_CHECK_ERROR(103,"密码确认错误"),
    INTERNAL_SERVER_ERR(500, "服务器内部错误"),
    FREIGHT(999, "运费模板中该地区已经定义");

    private final int code;
    private final String message;
    private static final Map<Integer, ReturnNo> returnNoMap = new HashMap<>();

    ReturnNo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ReturnNo getByCode(int code1) {
        ReturnNo[] all = values();
        ReturnNo[] var2 = all;
        int var3 = all.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ReturnNo returnNo = var2[var4];
            if (returnNo.code == code1) {
                return returnNo;
            }
        }
        return null;
    }

    public static ReturnNo getReturnNoByCode(int code) {
        return (ReturnNo)returnNoMap.get(code);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    static {
        ReturnNo[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            ReturnNo enum1 = var0[var2];
            returnNoMap.put(enum1.code, enum1);
        }
    }
}
