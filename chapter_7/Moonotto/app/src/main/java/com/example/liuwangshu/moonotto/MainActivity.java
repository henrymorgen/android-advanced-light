package com.example.liuwangshu.moonotto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {
    private Button bt_jump;
    private TextView tv_message;
    private Bus bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message= (TextView) this.findViewById(R.id.tv_message);
        bt_jump= (Button) this.findViewById(R.id.bt_jump);
        bt_jump.setText("跳转到SecondActivity");
        bt_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
        bus=OttoBus.getInstance();
        bus.register(this);
    }
    @Subscribe
    public void setContent(BusData data) {
        Log.i("wangshu","Subscribe");
        tv_message.setText(data.getMessage());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
