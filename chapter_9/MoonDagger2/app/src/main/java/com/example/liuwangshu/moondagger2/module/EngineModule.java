package com.example.liuwangshu.moondagger2.module;

import com.example.liuwangshu.moondagger2.annotation.Diesel;
import com.example.liuwangshu.moondagger2.annotation.Gasoline;
import com.example.liuwangshu.moondagger2.model.DieselEngine;
import com.example.liuwangshu.moondagger2.model.Engine;
import com.example.liuwangshu.moondagger2.model.GasolineEngine;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
@Module
public class EngineModule {
    @Provides
    @Gasoline
    public Engine provideGasoline() {
        return new GasolineEngine();
    }

    @Provides
    @Diesel
    public Engine provideDiesel() {
        return new DieselEngine();
    }
}
