package com.example.liuwangshu.moonmvpsimple.net;

import com.example.liuwangshu.moonmvpsimple.LoadTasksCallBack;
import com.example.liuwangshu.moonmvpsimple.ipinfo.IpInfoContract;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public interface NetTask<T> {
    void execute(T data , LoadTasksCallBack callBack);
}
