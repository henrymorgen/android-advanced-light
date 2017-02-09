package com.example.liuwangshu.moondagger2.component;

import com.example.liuwangshu.moondagger2.MainActivity;
import com.example.liuwangshu.moondagger2.SecondActivity;
import com.example.liuwangshu.moondagger2.annotation.ApplicationScope;
import com.example.liuwangshu.moondagger2.model.Swordsman;
import com.example.liuwangshu.moondagger2.module.EngineModule;
import com.example.liuwangshu.moondagger2.module.GsonModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
@ApplicationScope
@Component(modules = {GsonModule.class,EngineModule.class},dependencies = SwordsmanComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(SecondActivity activity);
}
