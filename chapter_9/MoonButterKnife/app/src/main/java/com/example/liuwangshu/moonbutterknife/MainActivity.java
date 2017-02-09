package com.example.liuwangshu.moonbutterknife;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;
import butterknife.OnTouch;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_text)
    TextView tv_text;
    @BindView(R.id.lv_list)
    ListView lv_list;
    @BindViews({R.id.bt_button1, R.id.bt_button2})
    List<Button> buttonList;
    @BindString(R.string.app_name)
    String appName;
    @BindArray(R.array.swordsman)
    String[] swordsman;
    @BindDimen(R.dimen.activity_horizontal_margin)
    float margin;

    @OnTextChanged(value = R.id.et_edittext,callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.i("wangshu", "befor"+s);
    }
    @OnTextChanged(value = R.id.et_edittext,callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("wangshu", "change"+s);
    }
    @OnTextChanged(value = R.id.et_edittext, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTextChanged(Editable s) {
        Log.i("wangshu", "after"+s.toString());
    }
    @OnClick(R.id.bt_button1)
    public void showToast() {
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show();
    }

    @OnTouch(R.id.bt_button2)
    public boolean onTouch(View view, MotionEvent event){
        Toast.makeText(this, "onTouch", Toast.LENGTH_SHORT).show();
        return true;
    }

    @OnItemClick(R.id.lv_list)
    void onItemClick(int position) {
        Toast.makeText(this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tv_text.setText("BindView");
        buttonList.get(0).setText(appName);
        buttonList.get(1).setText(swordsman[0]);
        SwordsmanAdapter adapter=new SwordsmanAdapter(MainActivity.this,R.layout.item_swordsman,getListData());
        lv_list.setAdapter(adapter);
    }
    public List<Swordsman> getListData(){
        List<Swordsman> list=new ArrayList<>();
        Swordsman swordsman1=new Swordsman("张无忌");
        Swordsman swordsman2=new Swordsman("张三丰");
        Swordsman swordsman3=new Swordsman("风清扬");
        list.add(swordsman1);
        list.add(swordsman2);
        list.add(swordsman3);
        return list;
    }
}
