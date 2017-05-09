package com.framgia.fdms.screen.requestmanager;

import android.databinding.ObservableField;
import com.framgia.fdms.BaseFragmentModel;
import com.framgia.fdms.data.model.Request;

/**
 * Exposes the data to be used in the RequestManager screen.
 */

public class RequestManagerViewModel extends BaseFragmentModel<Request>
        implements RequestManagerContract.ViewModel {

    private RequestManagerPresenter mPresenter;
    private RequestManagerAdapter mAdapter;
    private ObservableField<Boolean> mIsLoadingMore = new ObservableField<>(false);

    public RequestManagerViewModel(RequestManagerAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public void onStart() {
        if (mPresenter == null) return;
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        if (mPresenter == null) return;
        mPresenter.onStop();
    }

    public void setPresenter(RequestManagerPresenter presenter) {
        mPresenter = presenter;
    }

    public void setAdapter(RequestManagerAdapter adapter) {
        mAdapter = adapter;
    }

    public RequestManagerAdapter getAdapter() {
        return mAdapter;
    }
}
