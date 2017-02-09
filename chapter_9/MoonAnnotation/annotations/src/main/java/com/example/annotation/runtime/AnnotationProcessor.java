package com.example.annotation.runtime;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/12/12 0012.
 */

public class AnnotationProcessor {
    public static void main(String[] args) {
        Method[] methods = AnnotationTest.class.getDeclaredMethods();
        for (Method m:methods){
            GET get= m.getAnnotation(GET.class);
            System.out.println(get.value());
        }
    }
}
