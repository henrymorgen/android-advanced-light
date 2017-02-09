package com.example.liuwangshu.moondagger2.model;

import com.example.liuwangshu.moondagger2.annotation.Diesel;
import com.example.liuwangshu.moondagger2.annotation.Gasoline;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2016/12/18 0018.
 */

public class Car {
    private Engine engine;

    @Inject
    public Car(@Gasoline Engine engine) {
        this.engine = engine;
    }

    public String run() {
        return engine.work();
    }
}
