package com.example.annotation.runtime;

/**
 * Created by Administrator on 2016/12/11 0011.
 */

public class AnnotationTest {
    @GET(value = "http://ip.taobao.com/59.108.54.37")
    public String getIpMsg() {
     return "";
    }
    @GET(value = "http://ip.taobao.com/")
    public String getIp() {
        return "";
    }
}
