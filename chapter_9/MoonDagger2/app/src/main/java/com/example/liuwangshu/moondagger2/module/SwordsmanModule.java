package com.example.liuwangshu.moondagger2.module;

import com.example.liuwangshu.moondagger2.model.Swordsman;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
@Module
public class SwordsmanModule {
    @Provides
    public Swordsman provideSwordsman() {
        return new Swordsman();
    }
}

