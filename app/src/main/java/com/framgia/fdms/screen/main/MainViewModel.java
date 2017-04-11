package com.framgia.fdms.screen.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.view.View;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.screen.detail.DetailActivity;
import com.framgia.fdms.screen.device.DeviceActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Main screen.
 */
public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    public final ObservableField<Integer> progressBarVisibility = new ObservableField<>();
    private Context mContext;
    private MainContract.Presenter mPresenter;
    private DeviceListAdapter mAdapter;
    private List<Device> mDevices = new ArrayList<>();

    public MainViewModel(Context context) {
        mContext = context;
        mAdapter = new DeviceListAdapter(mContext, mDevices);
        mAdapter.setItemClickListener(
                new BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Device>() {

                    @Override
                    public void onItemRecyclerViewClick(Device item) {
                        mContext.startActivity(
                                new Intent(DetailActivity.getDeviceIntent(mContext, item)));
                    }
                });
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
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDeviceLoaded(List<Device> devices) {
        mAdapter.updateData(devices);
    }

    @Bindable
    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onError() {
        //TODO dev later
    }

    @Override
    public void showProgressbar() {
        progressBarVisibility.set(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBarVisibility.set(View.GONE);
    }

    public void onRegisterDeviceClick() {
        mContext.startActivity(new Intent(mContext, DeviceActivity.class));
    }
}
