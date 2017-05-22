package com.framgia.fdms.screen.returndevice;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Status;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the ReturnDevice screen.
 */

public class ReturnDeviceViewModel implements ReturnDeviceContract.ViewModel {

    private AppCompatActivity mActivity;
    private List<Device> mDevices = new ArrayList<>();
    private ReturnDeviceContract.Presenter mPresenter;
    private ObservableField<DeviceReturnAdapter> mAdapter = new ObservableField<>();

    private ObservableField<AssignerAdapter> mAssignerAdapter = new ObservableField<>();
    private ObservableList<Status> mAssigners = new ObservableArrayList<>();

    private ObservableField<Status> mNameUserReturn = new ObservableField<>();

    public ReturnDeviceViewModel(AppCompatActivity activity) {
        mActivity = activity;
        mAdapter.set(new DeviceReturnAdapter(this, mDevices));
        mAssignerAdapter.set(new AssignerAdapter(mActivity, this, mAssigners));
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
    public void setPresenter(ReturnDeviceContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCheckedChanged(boolean checked, Device device, int position) {
        // TODO: 5/22/2017 work when checkbox item of device return
    }

    @Override
    public void onClickItemAssigner(Status status, int position) {

    }

    @Override
    public void onReturnDevice() {
        // TODO: 5/23/2017 work save return device
    }

    @Override
    public void showProgressbar() {
        // TODO: later
    }

    @Override
    public void hideProgressbar() {
        // TODO: later
    }

    @Override
    public void onLoadError(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetAssignedSuccess(List<Status> assignees) {
        if (assignees == null) {
            return;
        }
        mAssigners.addAll(assignees);
        mAssignerAdapter.get().update(mAssigners);
    }

    public AppCompatActivity getActivity() {
        return mActivity;
    }

    public ObservableField<DeviceReturnAdapter> getAdapter() {
        return mAdapter;
    }

    public ObservableField<AssignerAdapter> getAssignerAdapter() {
        return mAssignerAdapter;
    }

    public ObservableList<Status> getAssigners() {
        return mAssigners;
    }

    public ObservableField<Status> getNameUserReturn() {
        return mNameUserReturn;
    }
}
