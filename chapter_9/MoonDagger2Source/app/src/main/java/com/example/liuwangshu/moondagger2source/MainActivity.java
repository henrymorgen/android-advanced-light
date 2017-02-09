package com.example.liuwangshu.moondagger2source;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.liuwangshu.moondagger2source.component.DaggerActivityComponent;
import com.example.liuwangshu.moondagger2source.model.Watch;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Watch watch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.create().inject(this);
        String sr=watch.work();
        Log.i("wangshu",sr);
    }
}
