package com.relink.chat.core.util;

public class ReturnObject<T> {
    ReturnNo code;
    String errmsg;
    private T data;

    public ReturnObject() {
        this.code = ReturnNo.OK;
        this.errmsg = null;
        this.data = null;
    }

    public ReturnObject(T data) {
        this();
        this.data = data;
    }

    public ReturnObject(ReturnNo code) {
        this.code = ReturnNo.OK;
        this.errmsg = null;
        this.data = null;
        this.code = code;
    }

    public ReturnObject(ReturnNo code, String errmsg) {
        this(code);
        this.errmsg = errmsg;
    }

    public ReturnObject(ReturnNo code, T data) {
        this(code);
        this.data = data;
    }

    public ReturnObject(ReturnNo code, String errmsg, T data) {
        this(code, errmsg);
        this.data = data;
    }

    public String getErrmsg() {
        return null != this.errmsg ? this.errmsg : this.code.getMessage();
    }

    public ReturnNo getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }
}
