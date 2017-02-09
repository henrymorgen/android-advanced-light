package com.example.liuwangshu.moondagger2.component;

import com.example.liuwangshu.moondagger2.model.Swordsman;
import com.example.liuwangshu.moondagger2.module.SwordsmanModule;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
@Component(modules = SwordsmanModule.class)
public interface SwordsmanComponent {
    Swordsman getSwordsman();
}
