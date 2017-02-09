package com.example.liuwangshu.moonmvpsimple.ipinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.liuwangshu.moonmvpsimple.R;
import com.example.liuwangshu.moonmvpsimple.net.IpInfoTask;
import com.example.liuwangshu.moonmvpsimple.util.ActivityUtils;

public class IpInfoActivity extends AppCompatActivity {
    private IpInfoPresenter ipInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipinfo);
        IpInfoFragment ipInfoFragment = (IpInfoFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (ipInfoFragment == null) {
            ipInfoFragment = IpInfoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    ipInfoFragment, R.id.contentFrame);
        }
        IpInfoTask ipInfoTask = IpInfoTask.getInstance();
        ipInfoPresenter = new IpInfoPresenter(ipInfoFragment, ipInfoTask);
        ipInfoFragment.setPresenter(ipInfoPresenter);
    }
}
