package com.framgia.fdms.screen.dashboard;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.databinding.ItemDashBoardBinding;
import java.util.List;

/**
 * Created by MyPC on 12/05/2017.
 */

public class DashBoardAdapter extends BaseRecyclerViewAdapter<Dashboard, DashBoardAdapter.ViewHolder> {
    private List<Dashboard> mDashboards;
    private DashBoardViewModel mViewModel;

    protected DashBoardAdapter(@NonNull Context context, @NonNull List<Dashboard> dashboards,
            @NonNull DashBoardViewModel viewModel) {
        super(context);
        mDashboards = dashboards;
        mViewModel = viewModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDashBoardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_dash_board, parent, false);
        return new ViewHolder(binding, mViewModel);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mDashboards.get(position));
    }

    @Override
    public int getItemCount() {
        return mDashboards == null ? 0 : mDashboards.size();
    }

    @Override
    public void onUpdatePage(List<Dashboard> data) {
        if (data == null){
            return;
        }
        mDashboards.addAll(data);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemDashBoardBinding mBinding;
        private DashBoardViewModel mViewModel;

        public ViewHolder(ItemDashBoardBinding binding, DashBoardViewModel viewModel) {
            super(binding.getRoot());
            mBinding = binding;
            mViewModel = viewModel;
        }

        void bindData(Dashboard dashboard){
            if (dashboard == null){
                return;
            }

            mBinding.setViewModel(mViewModel);
            mBinding.setDashboard(dashboard);
            mBinding.executePendingBindings();
        }
    }
}

