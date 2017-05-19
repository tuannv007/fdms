package com.framgia.fdms.screen.request;

/**
 * Exposes the data to be used in the Request screen.
 */

public class RequestViewModel implements RequestContract.ViewModel {

    private RequestContract.Presenter mPresenter;
    private RequestPagerAdapter mAdapter;
    private RequestFragment mFragment;

    public RequestViewModel(RequestFragment fragment) {
        mFragment = fragment;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
        mAdapter = new RequestPagerAdapter(mFragment.getContext(),
                mFragment.getChildFragmentManager());
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(RequestContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public RequestPagerAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(RequestPagerAdapter adapter) {
        mAdapter = adapter;
    }
}
