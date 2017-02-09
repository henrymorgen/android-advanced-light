package com.example.liuwangshu.moonmvpsimple.ipinfo;

import com.example.liuwangshu.moonmvpsimple.ApplicationModule;

import com.example.liuwangshu.moonmvpsimple.net.NetTaskComponent;
import com.example.liuwangshu.moonmvpsimple.util.FragmentScoped;

import dagger.Component;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
@FragmentScoped
@Component(dependencies = NetTaskComponent.class,modules = IpInfoModule.class)
public interface IpInfoComponent {
    void inject(IpInfoActivity ipInfoActivity);
}
