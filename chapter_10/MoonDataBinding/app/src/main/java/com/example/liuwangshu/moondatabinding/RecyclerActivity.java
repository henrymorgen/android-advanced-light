package com.example.liuwangshu.moondatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.liuwangshu.moondatabinding.adapter.SwordsmanAdapter;
import com.example.liuwangshu.moondatabinding.databinding.ActivityRecyclerBinding;
import com.example.liuwangshu.moondatabinding.model.Swordsman;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private ActivityRecyclerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        initRecyclerView();
    }
    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(RecyclerActivity.this);
        binding.recycler.setLayoutManager(manager);
        SwordsmanAdapter adapter=new SwordsmanAdapter(getList());
        binding.recycler.setAdapter(adapter);
    }
    private List<Swordsman> getList(){
        List<Swordsman> list =new ArrayList<>();
        Swordsman swordman1=new Swordsman("杨影枫","SS");
        Swordsman swordman2=new Swordsman("月眉儿","A");
        list.add(swordman1);
        list.add(swordman2);
        return list;
    }
}
