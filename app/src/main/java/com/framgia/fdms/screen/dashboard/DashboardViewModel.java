package com.framgia.fdms.screen.dashboard;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.IntDef;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.framgia.fdms.BR;

/**
 * Exposes the data to be used in the Dashboard screen.
 */

public class DashboardViewModel extends BaseObservable implements DashboardContract.ViewModel {

    private DashboardContract.Presenter mPresenter;
    private ViewPagerAdapter mPagerAdapter;
    private int mTab = Tab.TAB_DEVIVE_DASH_BOARD;

    public DashboardViewModel(DashboardFragment fragment) {
        mPagerAdapter = new ViewPagerAdapter(fragment.getChildFragmentManager());
    }

    public void onDirectChildTab(@Tab int tab, ViewPager viewPager) {
        if (mPagerAdapter == null) return;
        viewPager.setCurrentItem(tab);
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

    @Bindable
    public int getTab() {
        return mTab;
    }

    public void setTab(int tab) {
        mTab = tab;
        notifyPropertyChanged(BR.tab);
    }

    @IntDef({
            Tab.TAB_DEVIVE_DASH_BOARD, Tab.TAB_REQUEST_DASH_BOARD
    })
    public @interface Tab {
        int TAB_DEVIVE_DASH_BOARD = 0;
        int TAB_REQUEST_DASH_BOARD = 1;
    }
}
