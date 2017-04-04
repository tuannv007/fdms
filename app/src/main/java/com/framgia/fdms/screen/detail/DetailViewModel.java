package com.framgia.fdms.screen.detail;

/**
 * Exposes the data to be used in the Detail screen.
 */

public class DetailViewModel implements DetailContract.ViewModel {

    private DetailContract.Presenter mPresenter;

    public DetailViewModel() {
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
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
