package com.framgia.fdms.screen.dashboard;

/**
 * Exposes the data to be used in the Scanner screen.
 */

public class DashBoardViewModel implements DashBoardContract.ViewModel {

    private DashBoardContract.Presenter mPresenter;

    public DashBoardViewModel() {
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
    public void setPresenter(DashBoardContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
