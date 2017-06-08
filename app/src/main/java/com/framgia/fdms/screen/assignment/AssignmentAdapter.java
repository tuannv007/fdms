package com.framgia.fdms.screen.assignment;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.fdms.BR;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.api.request.DeviceRequest;
import com.framgia.fdms.databinding.ItemAssignmentBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 09/06/2017.
 */

public class AssignmentAdapter
        extends BaseRecyclerViewAdapter<DeviceRequest, AssignmentAdapter.ViewHolder> {
    private List<DeviceRequest> mDeviceRequests;
    private AssignmentViewModel mViewModel;

    protected AssignmentAdapter(@NonNull Context context, @NonNull AssignmentViewModel viewModel) {
        super(context);
        mViewModel = viewModel;
        mDeviceRequests = new ArrayList<>();
    }

    public void addItem() {
        mDeviceRequests.add(new DeviceRequest());
        notifyItemInserted(mDeviceRequests.size() - 1);
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAssignmentBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_assignment, parent, false);
        return new ViewHolder(binding, mViewModel);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mDeviceRequests.get(position));
    }

    @Override
    public int getItemCount() {
        return mDeviceRequests == null ? 0 : mDeviceRequests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ItemAssignmentBinding mBinding;
        private AssignmentViewModel mViewModel;

        public ViewHolder(ItemAssignmentBinding binding, AssignmentViewModel viewModel) {
            super(binding.getRoot());
            mBinding = binding;
            mViewModel = viewModel;
        }

        void bindData(DeviceRequest deviceRequest) {
            if (deviceRequest == null) {
                return;
            }

            ViewHolderModel model = new ViewHolderModel(deviceRequest, mViewModel, this);
            mBinding.setViewHolderModel(model);
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            if (getAdapterPosition() >= 0 && getAdapterPosition() < mDeviceRequests.size()) {
                mDeviceRequests.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
                notifyItemRangeChanged(getAdapterPosition(), mDeviceRequests.size());
            }
        }
    }

    public class ViewHolderModel extends BaseObservable {
        private DeviceRequest mDeviceRequest;
        private AssignmentViewModel mViewModel;
        private View.OnClickListener mOnDeleteClick;

        public ViewHolderModel(DeviceRequest deviceRequest, AssignmentViewModel viewModel,
                View.OnClickListener onDelteClick) {
            mDeviceRequest = deviceRequest;
            mViewModel = viewModel;
            mOnDeleteClick = onDelteClick;
        }

        @Bindable
        public DeviceRequest getDeviceRequest() {
            return mDeviceRequest;
        }

        public void setDeviceRequest(DeviceRequest deviceRequest) {
            mDeviceRequest = deviceRequest;
            notifyPropertyChanged(BR.deviceRequest);
        }

        @Bindable
        public AssignmentViewModel getViewModel() {
            return mViewModel;
        }

        public void setViewModel(AssignmentViewModel viewModel) {
            mViewModel = viewModel;
            notifyPropertyChanged(BR.viewModel);
        }

        @Bindable
        public View.OnClickListener getOnDelteClick() {
            return mOnDeleteClick;
        }

        public void setOnDelteClick(View.OnClickListener onDelteClick) {
            mOnDeleteClick = onDelteClick;
            notifyPropertyChanged(BR.onDelteClick);
        }
    }
}
