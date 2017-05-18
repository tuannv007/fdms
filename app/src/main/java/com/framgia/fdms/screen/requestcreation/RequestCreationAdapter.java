package com.framgia.fdms.screen.requestcreation;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.api.request.DeviceRequest;
import com.framgia.fdms.data.source.api.request.RequestCreatorRequest;
import com.framgia.fdms.databinding.ItemRequestCreationBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 18/05/2017.
 */

public class RequestCreationAdapter extends
        BaseRecyclerViewAdapter<DeviceRequest, RequestCreationAdapter
                .ViewHolder> {
    private List<DeviceRequest> mDeviceRequests;
    private RequestCreationViewModel mViewModel;

    public RequestCreationAdapter(@NonNull Context context,
            @NonNull RequestCreationViewModel viewModel) {
        super(context);
        mViewModel = viewModel;
        mDeviceRequests = new ArrayList<>();
        addItem();
    }

    public void addItem() {
        mDeviceRequests.add(new DeviceRequest());
        notifyDataSetChanged();
    }

    public List<DeviceRequest> getData() {
        return mDeviceRequests;
    }

    @Override
    public void onUpdatePage(List<DeviceRequest> data) {
        if (data == null) {
            return;
        }
        mDeviceRequests.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public RequestCreationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRequestCreationBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_request_creation, parent, false);
        return new ViewHolder(binding, mViewModel);
    }

    @Override
    public void onBindViewHolder(RequestCreationAdapter.ViewHolder holder, int position) {
        holder.bindData(position, mDeviceRequests.get(position));
    }

    @Override
    public int getItemCount() {
        return mDeviceRequests == null ? 0 : mDeviceRequests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRequestCreationBinding mBinding;
        private RequestCreationViewModel mViewModel;

        public ViewHolder(ItemRequestCreationBinding binding, RequestCreationViewModel viewModel) {
            super(binding.getRoot());
            mBinding = binding;
            mViewModel = viewModel;
        }

        void bindData(int position, DeviceRequest deviceRequest) {
            if (deviceRequest == null) {
                return;
            }

            mBinding.setPosition(position);
            mBinding.setViewModel(mViewModel);
            mBinding.setDeviceRequest(deviceRequest);
            mBinding.executePendingBindings();
        }
    }
}
