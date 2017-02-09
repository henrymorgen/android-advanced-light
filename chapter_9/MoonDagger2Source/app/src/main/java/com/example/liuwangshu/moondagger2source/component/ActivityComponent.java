package com.example.liuwangshu.moondagger2source.component;

import com.example.liuwangshu.moondagger2source.MainActivity;
import com.example.liuwangshu.moondagger2source.module.WatchModule;

import dagger.Component;

/**
 * Created by Administrator on 2016/12/23 0023.
 */

@Component(modules = WatchModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}

