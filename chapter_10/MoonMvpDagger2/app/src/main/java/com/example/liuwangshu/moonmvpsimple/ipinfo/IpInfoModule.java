package com.example.liuwangshu.moonmvpsimple.ipinfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
@Module
public class IpInfoModule {
    private IpInfoContract.View mView;
    public IpInfoModule(IpInfoContract.View mView){
        this.mView=mView;
    }
    @Provides
    IpInfoContract.View provideIpInfoContract() {
        return mView;
    }
}
