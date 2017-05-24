package com.framgia.fdms.screen.devicedetail;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Exposes the data to be used in the Devicedetail screen.
 */

public class DeviceDetailViewModel implements DeviceDetailContract.ViewModel {

    private DeviceDetailContract.Presenter mPresenter;
    private DeviceDetailPagerAdapter mAdapter;
    private Context mContext;
    private AppCompatActivity mActivity;

    public DeviceDetailViewModel(AppCompatActivity activity, int deviceId) {
        mActivity = activity;
        mContext = mActivity.getApplicationContext();
        mAdapter = new DeviceDetailPagerAdapter(mContext, mActivity.getSupportFragmentManager(),
                deviceId);
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(DeviceDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public DeviceDetailPagerAdapter getAdapter() {
        return mAdapter;
    }

    public AppCompatActivity getActivity() {
        return mActivity;
    }
}
