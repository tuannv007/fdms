package com.framgia.fdms.screen.requestdetail;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.databinding.ItemRequesDetailDeviceBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuanbg on 5/25/17.
 */

public class RequestDetailAdapter
        extends BaseRecyclerViewAdapter<Request.DeviceRequest, RequestDetailAdapter.ViewHolder> {
    private List<Request.DeviceRequest> mDeviceRequests = new ArrayList<>();
    private RequestDetailViewModel mViewModel;

    protected RequestDetailAdapter(@NonNull Context context, RequestDetailViewModel viewModel,
            List<Request.DeviceRequest> mListRequest) {
        super(context);
        mViewModel = viewModel;
        mDeviceRequests = mListRequest;
    }

    @Override
    public void onUpdatePage(List<Request.DeviceRequest> data) {
       /* if (data == null) {
            return;
        }
        mDeviceRequests.addAll(data);
        notifyDataSetChanged();*/
    }

    public void addItem() {
        mDeviceRequests.add(new Request.DeviceRequest());
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRequesDetailDeviceBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_reques_detail_device, parent, false);
        binding.setViewModel(mViewModel);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(position, mDeviceRequests.get(position));
        Log.e("dmm", mDeviceRequests.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mDeviceRequests != null ? mDeviceRequests.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRequesDetailDeviceBinding mBinding;

        public ViewHolder(ItemRequesDetailDeviceBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindData(int position, Request.DeviceRequest deviceRequest) {
            mBinding.setDeviceRequest(deviceRequest);
            mBinding.executePendingBindings();
            mBinding.setPosition(position);
        }
    }
}
