package com.example.liuwangshu.moonrxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liuwangshu.moonrxjava.bus.RxBusActivity;
import com.example.liuwangshu.moonrxjava.net.OkhttpActivity;
import com.example.liuwangshu.moonrxjava.net.RetrofitActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_okhttp;
    private Button bt_create;
    private Button bt_filter;
    private Button bt_transform;
    private Button bt_combine;
    private Button bt_utility;
    private Button bt_error;
    private Button bt_conditional;
    private Button bt_conversion;
    private Button bt_retrofit;
    private Button bt_rxbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt_create = (Button) this.findViewById(R.id.bt_create);
        bt_transform = (Button) this.findViewById(R.id.bt_conversion);
        bt_filter = (Button) this.findViewById(R.id.bt_filter);
        bt_combine = (Button) this.findViewById(R.id.bt_combine);
        bt_utility = (Button) this.findViewById(R.id.bt_utility);
        bt_error = (Button) this.findViewById(R.id.bt_error);
        bt_conditional = (Button) this.findViewById(R.id.bt_conditional);
        bt_conversion = (Button) this.findViewById(R.id.bt_conversion);
        bt_okhttp = (Button) this.findViewById(R.id.bt_okhttp);
        bt_retrofit= (Button) this.findViewById(R.id.bt_retrofit);
        bt_rxbus= (Button) this.findViewById(R.id.bt_rxbus);
        bt_filter.setOnClickListener(this);
        bt_create.setOnClickListener(this);
        bt_transform.setOnClickListener(this);
        bt_combine.setOnClickListener(this);
        bt_utility.setOnClickListener(this);
        bt_error.setOnClickListener(this);
        bt_conditional.setOnClickListener(this);
        bt_conversion.setOnClickListener(this);
        bt_okhttp.setOnClickListener(this);
        bt_retrofit.setOnClickListener(this);
        bt_rxbus.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_create:
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_transform:
                Intent transformIntent = new Intent(MainActivity.this, TransformActivity.class);
                startActivity(transformIntent);
                break;

            case R.id.bt_filter:
                Intent filterIntent = new Intent(MainActivity.this, FilterActivity.class);
                startActivity(filterIntent);
                break;
            case R.id.bt_combine:
                Intent combineIntent = new Intent(MainActivity.this, CombineActivity.class);
                startActivity(combineIntent);

                break;
            case R.id.bt_utility:
                Intent utilityIntent = new Intent(MainActivity.this, UtilityActivity.class);
                startActivity(utilityIntent);
                break;
            case R.id.bt_error:
                Intent errorIntent = new Intent(MainActivity.this, ErrorActivity.class);
                startActivity(errorIntent);
                break;
            case R.id.bt_conditional:
                Intent conditionalIntent = new Intent(MainActivity.this, ConditionalActivity.class);
                startActivity(conditionalIntent);
                break;
            case R.id.bt_conversion:
                Intent conversionIntent = new Intent(MainActivity.this, ConversionActivity.class);
                startActivity(conversionIntent);
                break;

            case R.id.bt_okhttp:
                Intent okhttpIntent = new Intent(MainActivity.this, OkhttpActivity.class);
                startActivity(okhttpIntent);
                break;
            case R.id.bt_retrofit:
                Intent retrofitIntent = new Intent(MainActivity.this, RetrofitActivity.class);
                startActivity(retrofitIntent);
                break;
            case R.id.bt_rxbus:
                Intent rxbusIntent = new Intent(MainActivity.this, RxBusActivity.class);
                startActivity(rxbusIntent);
                break;
        }
    }
}
