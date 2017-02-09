package com.example.liuwangshu.moonannotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.annotation.cls.BindView;
import com.example.annotation.runtime.GET;

public class MainActivity extends AppCompatActivity {
    @BindView(value = R.id.tv_text)
    TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
