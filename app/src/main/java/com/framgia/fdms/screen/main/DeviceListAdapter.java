package com.framgia.fdms.screen.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.databinding.ItemDataBinding;
import java.util.List;

/**
 * Adapter show list device
 */
public class DeviceListAdapter
        extends BaseRecyclerViewAdapter<Device, DeviceListAdapter.ViewHolder> {
    private List<Device> mListDevice;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Device> mItemClickListener;

    public DeviceListAdapter(@NonNull Context context, @NonNull List<Device> listDevice) {
        super(context);
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
        return new ViewHolder(itemDataBinding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mListDevice.get(position));
    }

    @Override
    public int getItemCount() {
        return mListDevice == null ? 0 : mListDevice.size();
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener<Device> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onUpdatePage(List data) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemDataBinding mBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Device> mItemClickListener;

        public ViewHolder(ItemDataBinding dataBinding,
                BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Device> listener) {
            super(dataBinding.getRoot());
            mBinding = dataBinding;
            mItemClickListener = listener;
        }

        public void bindData(Device device) {
            if (device == null) {
                return;
            }
            mBinding.setViewModel(new ItemDeviceResultViewModel(device, mItemClickListener));
            mBinding.setItem(device);
            mBinding.executePendingBindings();
        }
    }
}
