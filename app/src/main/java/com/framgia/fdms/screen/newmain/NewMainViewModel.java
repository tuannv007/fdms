package com.framgia.fdms.screen.newmain;

/**
 * Exposes the data to be used in the Newmain screen.
 */
public class NewMainViewModel implements NewMainContract.ViewModel {
    private NewMainContract.Presenter mPresenter;
    private ViewPagerAdapter mPagerAdapter;

    public NewMainViewModel(ViewPagerAdapter adapter) {
        mPagerAdapter = adapter;
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
    public void setPresenter(NewMainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public ViewPagerAdapter getPagerAdapter() {
        return mPagerAdapter;
    }
}
