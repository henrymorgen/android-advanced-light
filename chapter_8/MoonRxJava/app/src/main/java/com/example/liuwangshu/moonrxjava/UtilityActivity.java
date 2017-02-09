package com.example.liuwangshu.moonrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

/**
 * 辅助/错误操作符
 */
public class UtilityActivity extends AppCompatActivity {
    private static final String TAG="RxJava";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility);
        //delay();
        //doOnNext();
        //subscribeOn();
        timeout();


    }

    private void timeout() {
        Observable<Integer> obs = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for(int i=0;i<4;i++){
                    try {
                        Thread.sleep(i * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).timeout(200,TimeUnit.MILLISECONDS,Observable.just(10,11));
        obs.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "timeout:" + integer);
            }
        });
    }

    private void subscribeOn() {
        Observable<Integer> obs= Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                Log.d(TAG,"Observable:" + Thread.currentThread().getName());
                subscriber.onNext(1);
                subscriber.onCompleted();
            }
        });
        obs.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG,"Observer:" + Thread.currentThread().getName());
            }
        });
    }

    private void doOnNext() {
        Observable.just(1,2)
                .doOnNext(new Action1<Integer>() {
                    @Override
                    public void call(Integer item) {
                        Log.d(TAG,"call:" + item);

                    }
                }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onNext(Integer item) {
                Log.d(TAG,"onNext:" + item);
            }
            @Override
            public void onError(Throwable error) {
                Log.d(TAG,"Error:" + error.getMessage());
            }
            @Override
            public void onCompleted() {
                Log.d(TAG,"onCompleted");
            }
        });

    }

    private void delay() {
        Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                Long currentTime=System.currentTimeMillis()/1000;
                subscriber.onNext(currentTime);
            }
        }).delay(2,TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Log.d(TAG, "delay:"+(System.currentTimeMillis()/1000-aLong));
            }
        });
    }
}
