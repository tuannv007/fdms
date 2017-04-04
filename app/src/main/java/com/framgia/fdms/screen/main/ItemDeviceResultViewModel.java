package com.framgia.fdms.screen.main;

import android.databinding.BaseObservable;
import android.view.View;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.data.model.Device;

public class ItemDeviceResultViewModel extends BaseObservable {

    private Device mDevice;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Device> mItemClickListener;

    public ItemDeviceResultViewModel(Device device,
            BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Device> listener) {
        mDevice = device;
        mItemClickListener = listener;
    }

    public void onItemClicked(View view) {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mDevice);
    }
}
