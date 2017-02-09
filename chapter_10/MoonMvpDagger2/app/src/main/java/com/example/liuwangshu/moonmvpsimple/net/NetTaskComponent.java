package com.example.liuwangshu.moonmvpsimple.net;

import com.example.liuwangshu.moonmvpsimple.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
@Singleton
@Component(modules =NetTaskModule.class)
public interface NetTaskComponent {
    NetTask getNetTask();
}
