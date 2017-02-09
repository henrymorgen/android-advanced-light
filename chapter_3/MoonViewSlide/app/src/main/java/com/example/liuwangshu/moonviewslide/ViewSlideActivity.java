package com.example.liuwangshu.moonviewslide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

public class ViewSlideActivity extends AppCompatActivity {
    private CustomView mCustomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_slide);
        mCustomView= (CustomView) this.findViewById(R.id.customview);
        //使用属性动画使view滑动
//        ObjectAnimator.ofFloat(mCustomView,"translationX",0,300).setDuration(1000).start();
        //使用View动画使view滑动
//      mCustomView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));

        //使用Scroll来进行平滑移动
        mCustomView.smoothScrollTo(-400,0);
    }
}
