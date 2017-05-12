package com.framgia.fdms.screen.requestmanager;

import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import com.framgia.fdms.BaseFragmentContract;
import com.framgia.fdms.BaseFragmentModel;
import com.framgia.fdms.data.model.Request;

/**
 * Exposes the data to be used in the RequestManager screen.
 */

public class RequestManagerViewModel extends BaseFragmentModel<Request>
        implements RequestManagerContract.ViewModel {

    private BaseFragmentContract.Presenter mPresenter;
    private RequestManagerAdapter mAdapter;
    private ObservableField<Boolean> mIsLoadingMore = new ObservableField<>(false);

    public RequestManagerViewModel(RequestManagerAdapter adapter, FragmentActivity activity) {
        mAdapter = adapter;
        setActivity(activity);
    }

    @Override
    public void onStart() {
        if (mPresenter == null) return;
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    public void setPresenter(BaseFragmentContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setAdapter(RequestManagerAdapter adapter) {
        mAdapter = adapter;
    }

    public RequestManagerAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onErrorLoadPage(String msg) {
        super.onErrorLoadPage(msg);
        Snackbar.make(getActivity().findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG)
                .show();
    }
}
