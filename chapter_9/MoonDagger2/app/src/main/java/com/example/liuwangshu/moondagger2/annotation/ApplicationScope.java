package com.example.liuwangshu.moondagger2.annotation;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
@Scope
@Retention(RUNTIME)
public @interface ApplicationScope {
}
