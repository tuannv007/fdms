package com.framgia.fdms.screen.historydetail;

import android.databinding.ObservableField;
import com.framgia.fdms.data.model.HistoryDetail;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the HistoryDetail screen.
 */

public class DeviceDetailHistoryViewModel implements DeviceDetailHistoryContract.ViewModel {

    private List<HistoryDetail> mHistoryDetails = new ArrayList<>();
    private DeviceDetailHistoryContract.Presenter mPresenter;
    private ObservableField<DeviceDetailHistoryAdapter> mAdapter = new ObservableField<>();

    public DeviceDetailHistoryViewModel() {
        mAdapter.set(new DeviceDetailHistoryAdapter(mHistoryDetails));
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
    public void setPresenter(DeviceDetailHistoryContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public ObservableField<DeviceDetailHistoryAdapter> getAdapter() {
        return mAdapter;
    }
}
