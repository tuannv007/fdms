package com.framgia.fdms.screen.requestmanager;

import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import com.framgia.fdms.BaseFragmentContract;
import com.framgia.fdms.BaseFragmentModel;
import com.framgia.fdms.data.model.Request;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the RequestManager screen.
 */

public class RequestManagerViewModel extends BaseFragmentModel<Request>
        implements RequestManagerContract.ViewModel {

    private BaseFragmentContract.Presenter mPresenter;
    private RequestManagerAdapter mAdapter;
    private ObservableField<Boolean> mIsLoadingMore = new ObservableField<>(false);

    public RequestManagerViewModel() {
        mAdapter = new RequestManagerAdapter(getActivity(), new ArrayList<Request>());
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

    @Override
    public void onGetRequestSuccess(List<Request> requests) {
        mAdapter.onUpdatePage(requests);
    }
}
