package com.example.liuwangshu.moondagger2.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2016/12/19 0019.
 */
@Qualifier
@Retention(RUNTIME)
public @interface Gasoline {
}
