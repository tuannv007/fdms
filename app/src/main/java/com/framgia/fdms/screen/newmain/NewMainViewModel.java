package com.framgia.fdms.screen.newmain;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.IntDef;
import com.framgia.fdms.BR;

import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_DASH_BOARD;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_DEVICE_MANAGER;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_REQUEST_MANAGER;

/**
 * Exposes the data to be used in the Newmain screen.
 */
public class NewMainViewModel extends BaseObservable implements NewMainContract.ViewModel {
    private NewMainContract.Presenter mPresenter;
    private ViewPagerAdapter mPagerAdapter;
    private int mTab = TAB_DASH_BOARD;

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

    @Bindable
    public int getTab() {
        return mTab;
    }

    public void setTab(int tab) {
        mTab = tab;
        notifyPropertyChanged(BR.tab);
    }

    @IntDef({
            TAB_DASH_BOARD, TAB_REQUEST_MANAGER, TAB_DEVICE_MANAGER, Tab.TAB_PROFILE
    })
    public @interface Tab {
        int TAB_DASH_BOARD = 0;
        int TAB_REQUEST_MANAGER = 1;
        int TAB_DEVICE_MANAGER = 2;
        int TAB_PROFILE = 3;
    }
}
