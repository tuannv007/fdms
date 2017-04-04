package com.framgia.fdms.screen.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.databinding.ItemDataBinding;
import java.util.List;

/**
 * Adapter show list device
 */
public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.ViewHolder> {
    private List<Device> mListDevice;

    public DeviceListAdapter(@NonNull List<Device> listDevice) {
        mListDevice = listDevice;
    }

    public void updateData(List<Device> list) {
        if (list == null) {
            return;
        }
        mListDevice.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDataBinding itemDataBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_device, parent, false);
        return new ViewHolder(itemDataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Device device = mListDevice.get(position);
        holder.bindData(device);
    }

    @Override
    public int getItemCount() {
        return mListDevice == null ? 0 : mListDevice.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemDataBinding mBinding;

        public ViewHolder(ItemDataBinding dataBinding) {
            super(dataBinding.getRoot());
            mBinding = dataBinding;
        }

        public void bindData(Device device) {
            if (device == null) {
                return;
            }
            mBinding.setItem(device);
            mBinding.executePendingBindings();
        }
    }
}
