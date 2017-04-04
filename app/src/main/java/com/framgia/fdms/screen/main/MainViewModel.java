package com.framgia.fdms.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.RecyclerView;

import com.framgia.fdms.data.model.Device;

import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Main screen.
 */
public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    private MainContract.Presenter mPresenter;
    private DeviceListAdapter mAdapter;
    private List<Device> mDevices = new ArrayList<>();

    public MainViewModel() {
        mAdapter = new DeviceListAdapter(mDevices);
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
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDeviceLoaded(List<Device> devices) {
        mAdapter.updateData(devices);
    }

    @Bindable
    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onError() {
        //TODO dev later
    }

    @Override
    public void showProgressbar() {
        //TODO dev later
    }

    @Override
    public void hideProgressbar() {
        //TODO dev later
    }
}
