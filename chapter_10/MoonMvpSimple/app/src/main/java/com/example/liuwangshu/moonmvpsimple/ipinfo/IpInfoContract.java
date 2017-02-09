package com.example.liuwangshu.moonmvpsimple.ipinfo;

import com.example.liuwangshu.moonmvpsimple.BaseView;
import com.example.liuwangshu.moonmvpsimple.model.IpInfo;


public interface IpInfoContract {
    interface Presenter {
        void getIpInfo(String ip);
    }

    interface View extends BaseView<Presenter> {
        void setIpInfo(IpInfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        boolean isActive();
    }
}
