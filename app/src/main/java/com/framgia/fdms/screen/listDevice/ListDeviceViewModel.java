package com.framgia.fdms.screen.listDevice;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.screen.device.DeviceActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the ListDevice screen.
 */

public class ListDeviceViewModel extends BaseObservable implements ListDeviceContract.ViewModel {
    private ObservableField<Integer> mProgressBarVisibility = new ObservableField<>();
    private ListDeviceAdapter mAdapter;
    private ListDeviceContract.Presenter mPresenter;
    private Context mContext;

    public ListDeviceViewModel(Context context) {
        mContext = context;
        mAdapter = new ListDeviceAdapter(mContext, new ArrayList<Device>(), this);
    }

    @Bindable
    public ListDeviceAdapter getAdapter() {
        return mAdapter;
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
    public void setPresenter(ListDeviceContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDeviceLoaded(List<Device> devices) {
        mAdapter.updateData(devices);
    }

    @Override
    public void onDeviceClick(Device device) {

    }

    @Override
    public void showProgressbar() {
        mProgressBarVisibility.set(View.VISIBLE);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgressbar() {
        mProgressBarVisibility.set(View.GONE);
    }

    @Override
    public void onRegisterDeviceClick() {
        mContext.startActivity(new Intent(mContext, DeviceActivity.class));
    }

    public ObservableField<Integer> getProgressBarVisibility() {
        return mProgressBarVisibility;
    }
}
