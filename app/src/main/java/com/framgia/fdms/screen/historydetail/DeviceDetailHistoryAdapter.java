package com.framgia.fdms.screen.historydetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.fdms.data.model.HistoryDetail;
import com.framgia.fdms.databinding.ItemHistoryDetailBinding;
import java.util.List;

/**
 * Created by Hoang Van Nha on 5/23/2017.
 * <></>
 */

public class DeviceDetailHistoryAdapter
        extends RecyclerView.Adapter<DeviceDetailHistoryAdapter.HistoryDetailHolder> {
    private List<HistoryDetail> mHistoryDetails;
    private LayoutInflater mInflater;

    public DeviceDetailHistoryAdapter(List<HistoryDetail> historyDetails) {
        mHistoryDetails = historyDetails;
    }

    @Override
    public HistoryDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mInflater == null) mInflater = LayoutInflater.from(parent.getContext());
        ItemHistoryDetailBinding binding =
                ItemHistoryDetailBinding.inflate(mInflater, parent, false);
        return new HistoryDetailHolder(binding);
    }

    @Override
    public void onBindViewHolder(HistoryDetailHolder holder, int position) {
        HistoryDetail historyDetail = mHistoryDetails.get(position);
        if (mHistoryDetails != null) holder.bind(historyDetail, position);
    }

    @Override
    public int getItemCount() {
        return mHistoryDetails == null ? 0 : mHistoryDetails.size();
    }

    public class HistoryDetailHolder extends RecyclerView.ViewHolder {

        private final ItemHistoryDetailBinding mBinding;

        public HistoryDetailHolder(ItemHistoryDetailBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        private void bind(HistoryDetail historyDetail, int position) {
            mBinding.setHistoryDetail(historyDetail);
            mBinding.setPosition(position);
            mBinding.executePendingBindings();
        }
    }
}
