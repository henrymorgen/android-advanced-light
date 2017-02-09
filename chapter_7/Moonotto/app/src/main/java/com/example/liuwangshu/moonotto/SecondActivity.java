package com.example.liuwangshu.moonotto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.squareup.otto.Produce;

/**
 * Created by Administrator on 2016/11/17 0017.
 */

public class SecondActivity extends AppCompatActivity {
    private Button bt_jump;
    private OttoBus bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_jump= (Button) this.findViewById(R.id.bt_jump);
        bt_jump.setText("发送事件");
        bt_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OttoBus.getInstance().post(new BusData("刘望舒的博客更新了"));
                finish();
            }
        });
        bus=OttoBus.getInstance();
        bus.register(this);
    }
//    @Produce
//    public BusData setInitialContent() {
//        Log.i("wangshu","Produce");
//        return new BusData("刘望舒的博客更新了");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        bus.unregister(this);
//    }
}
