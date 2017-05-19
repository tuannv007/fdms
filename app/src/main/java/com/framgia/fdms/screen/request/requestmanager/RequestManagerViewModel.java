package com.framgia.fdms.screen.request.requestmanager;

/**
 * Exposes the data to be used in the RequestManager screen.
 */

public class RequestManagerViewModel implements RequestManagerContract.ViewModel {

    private RequestManagerContract.Presenter mPresenter;

    public RequestManagerViewModel() {
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
    public void setPresenter(RequestManagerContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
