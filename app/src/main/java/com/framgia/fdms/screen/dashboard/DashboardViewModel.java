package com.framgia.fdms.screen.dashboard;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;

/**
 * Exposes the data to be used in the Dashboard screen.
 */

public class DashboardViewModel implements DashboardContract.ViewModel {

    private DashboardContract.Presenter mPresenter;
    private ViewPagerAdapter mPagerAdapter;

    public DashboardViewModel(DashboardFragment fragment) {
        mPagerAdapter = new ViewPagerAdapter(fragment.getChildFragmentManager());
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
    public void setPresenter(DashboardContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public ViewPagerAdapter getPagerAdapter() {
        return mPagerAdapter;
    }

    @IntDef({
            Tab.TAB_DEVIVE_DASH_BOARD, Tab.TAB_REQUEST_DASH_BOARD
    })
    public @interface Tab {
        int TAB_DEVIVE_DASH_BOARD = 0;
        int TAB_REQUEST_DASH_BOARD = 1;
    }
}
