package com.framgia.fdms.screen.search;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.RecyclerView;
import com.framgia.fdms.screen.main.DeviceListAdapter;

/**
 * Exposes the data to be used in the Search screen.
 */

public class SearchViewModel extends BaseObservable implements SearchContract.ViewModel {

    private SearchContract.Presenter mPresenter;
    private DeviceListAdapter mAdapter;

    public SearchViewModel() {
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
}
