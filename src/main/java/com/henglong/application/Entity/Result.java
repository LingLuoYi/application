package com.henglong.application.Entity;


public class Result<T> {
    /*状态码*/
    private String code;
    /*请求ip*/
    private String ip;
    /*请求方式*/
    private String mode;
    /*信息*/
    private String msg;
    /*数据*/
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
