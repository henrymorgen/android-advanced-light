package com.example.liuwangshu.moonmvpsimple.ipinfo;

import android.app.Dialog;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.liuwangshu.moonmvpsimple.R;
import com.example.liuwangshu.moonmvpsimple.databinding.FragmentIpinfoBinding;
import com.example.liuwangshu.moonmvpsimple.model.IpData;
import com.example.liuwangshu.moonmvpsimple.model.IpInfo;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class IpInfoFragment extends Fragment implements IpInfoContract.View {
    private Dialog mDialog;
    private IpInfoContract.Presenter mPresenter;
    private FragmentIpinfoBinding binding;

    public static IpInfoFragment newInstance() {
        return new IpInfoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentIpinfoBinding.inflate(inflater, container, false);
        }
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDialog = new ProgressDialog(getActivity());
        mDialog.setTitle("获取数据中");
        binding.btIpinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getIpInfo("39.155.184.147");
            }
        });
    }

    @Override
    public void setPresenter(IpInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setIpInfo(IpInfo ipInfo) {
        if (ipInfo != null && ipInfo.getData() != null) {
            IpData ipData = ipInfo.getData();
            binding.setIpdata(ipData);
        }
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity().getApplicationContext(), "网络出错", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
