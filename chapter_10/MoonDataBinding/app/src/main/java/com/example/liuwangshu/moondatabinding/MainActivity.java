package com.example.liuwangshu.moondatabinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



import com.example.liuwangshu.moondatabinding.databinding.ActivityMainBinding;
import com.example.liuwangshu.moondatabinding.model.Swordsman;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Swordsman swordsman=new Swordsman("张无忌","S");
        binding.setSwordsman(swordsman);
        binding.btLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LayoutActivity.class);
                startActivity(intent);
            }
        });

        binding.btUpdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });
        binding.btRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}
