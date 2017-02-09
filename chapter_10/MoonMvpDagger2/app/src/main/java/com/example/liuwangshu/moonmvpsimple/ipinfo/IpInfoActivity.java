package com.example.liuwangshu.moonmvpsimple.ipinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.liuwangshu.moonmvpsimple.MvpApplication;
import com.example.liuwangshu.moonmvpsimple.R;
import com.example.liuwangshu.moonmvpsimple.util.ActivityUtils;

import javax.inject.Inject;

public class IpInfoActivity extends AppCompatActivity {
    @Inject
    IpInfoPresenter ipInfoPresenter;
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
//        IpInfoTask ipInfoTask = new IpInfoTask();
//        ipInfoPresenter = new IpInfoPresenter(ipInfoFragment, ipInfoTask);
//        ipInfoFragment.setPresenter(ipInfoPresenter);
        DaggerIpInfoComponent.builder().ipInfoModule(new IpInfoModule(ipInfoFragment)).netTaskComponent(((MvpApplication) getApplication()).getTasksRepositoryComponent()).build().inject(this);
    }
}
