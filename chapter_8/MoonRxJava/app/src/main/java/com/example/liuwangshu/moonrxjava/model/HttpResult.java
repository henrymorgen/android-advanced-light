package com.example.liuwangshu.moonrxjava.model;


public class HttpResult<T> {
    private int code;
    private T data;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
