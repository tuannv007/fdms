package com.framgia.fdms.screen.usinghistory;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;

/**
 * Exposes the data to be used in the UsingHistory screen.
 */

public class DeviceUsingHistoryViewModel extends BaseObservable
        implements DeviceUsingHistoryContract.ViewModel {

    private DeviceUsingHistoryContract.Presenter mPresenter;
    private DeviceUsingAdapter mAdapter;

    public DeviceUsingHistoryViewModel() {
        mAdapter = new DeviceUsingAdapter();
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
    public void setPresenter(DeviceUsingHistoryContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public DeviceUsingAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(DeviceUsingAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }
}
