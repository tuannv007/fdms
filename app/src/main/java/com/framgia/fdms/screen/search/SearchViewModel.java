package com.framgia.fdms.screen.search;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.framgia.fdms.BaseRecyclerViewAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.screen.detail.DetailActivity;
import com.framgia.fdms.screen.main.DeviceListAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Search screen.
 */

public class SearchViewModel extends BaseObservable implements SearchContract.ViewModel {

    private Context mContext;
    private SearchContract.Presenter mPresenter;
    private DeviceListAdapter mAdapter;
    private List<Device> mDevices = new ArrayList<>();
    private String mKeyWord;
    public final ObservableField<Integer> progressBarVisibility = new ObservableField<>();

    public SearchViewModel(Context context) {
        mContext = context;
        progressBarVisibility.set(View.GONE);
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
    public void onClickSearch() {
        mDevices.clear();
        mPresenter.searchDevice(getKeyWord());
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
    public void setPresenter(SearchContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void searchDevicesSuccess(List<Device> devices) {
        mAdapter.updateData(devices);
    }

    @Override
    public void onSearchDevicesError() {
        Toast.makeText(mContext, R.string.msg_search_error, Toast.LENGTH_SHORT).show();
    }

    @Bindable
    public String getKeyWord() {
        return mKeyWord;
    }

    public void setKeyWord(String keyWord) {
        mKeyWord = keyWord;
    }

    @Override
    public void showProgressbar() {
        progressBarVisibility.set(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBarVisibility.set(View.GONE);
    }
}
