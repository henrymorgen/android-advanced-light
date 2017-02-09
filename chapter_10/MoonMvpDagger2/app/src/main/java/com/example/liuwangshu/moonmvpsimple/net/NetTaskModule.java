package com.example.liuwangshu.moonmvpsimple.net;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
@Module
public class NetTaskModule {
    @Singleton
    @Provides
    NetTask provideIpInfoTask() {
        return new IpInfoTask();
    }
}
