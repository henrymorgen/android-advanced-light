package com.example.liuwangshu.moonmvpsimple.net;

import android.util.Log;

import com.example.liuwangshu.moonmvpsimple.LoadTasksCallBack;
import com.example.liuwangshu.moonmvpsimple.model.IpInfo;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class IpInfoTask implements NetTask<String> {
    private static final String HOST = "http://ip.taobao.com/service/";
    private Retrofit retrofit;
    public IpInfoTask() {
        createRetrofit();
    }
    private void createRetrofit() {
        retrofit = new Retrofit.Builder().
                baseUrl(HOST).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                build();
    }

    @Override
    public Subscription execute(String ip, final LoadTasksCallBack loadTasksCallBack) {
        IpService ipService = retrofit.create(IpService.class);
        Subscription Subscription = ipService.getIpInfo(ip).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<IpInfo>() {
            @Override
            public void onStart() {
                loadTasksCallBack.onStart();
            }

            @Override
            public void onCompleted() {
                loadTasksCallBack.onFinish();
            }

            @Override
            public void onError(Throwable e) {
                loadTasksCallBack.onFailed();
            }

            @Override
            public void onNext(IpInfo ipInfo) {
                loadTasksCallBack.onSuccess(ipInfo);
            }
        });

        return Subscription;
    }
}


