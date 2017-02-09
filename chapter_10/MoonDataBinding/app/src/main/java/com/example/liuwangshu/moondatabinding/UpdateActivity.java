package com.example.liuwangshu.moondatabinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.liuwangshu.moondatabinding.databinding.ActivityUpdateBinding;
import com.example.liuwangshu.moondatabinding.model.ObFSwordsman;
import com.example.liuwangshu.moondatabinding.model.ObSwordsman;
import com.example.liuwangshu.moondatabinding.model.Swordsman;

public class UpdateActivity extends AppCompatActivity {
    private ActivityUpdateBinding binding;
    private ObservableArrayList<Swordsman> list;
    private ObSwordsman obSwordsman;
    private Swordsman swordsman1;
    private Swordsman swordsman2;
    private ObFSwordsman obfSwordsman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update);
        list = new ObservableArrayList<>();
        obSwordsman = new ObSwordsman("任我行", "A");
        binding.setObswordsman(obSwordsman);


        obfSwordsman = new ObFSwordsman("风清扬", "S");
        binding.setObfswordsman(obfSwordsman);

        swordsman1 = new Swordsman("张无忌", "S");
        swordsman2 = new Swordsman("周芷若", "B");
        list.add(swordsman1);
        list.add(swordsman2);
        binding.setList(list);

        binding.btUpdataObswordsman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obSwordsman.setName("东方不败");
            }
        });

        binding.btUpdataObfsswordsman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obfSwordsman.name.set("令狐冲");
            }
        });
        binding.btUpdataObmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swordsman1.setName("杨过");
                swordsman2.setName("小龙女");
                list.add(swordsman1);
            }
        });

        binding.btUpdataBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obSwordsman.setName("任我行");
            }
        });
    }
}
