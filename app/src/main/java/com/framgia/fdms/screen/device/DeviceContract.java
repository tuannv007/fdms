package com.framgia.fdms.screen.device;

import android.support.v4.view.ViewPager;
import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.User;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DeviceContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onClickChangeTab(ViewPager viewPager, int currentTab);

        void setupViewPager(User user);

        void onError(String message);

        void onStartReturnDevice(FloatingActionsMenu floatingActionsMenu);

        void onRegisterDeviceClick(FloatingActionsMenu floatingActionsMenu);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getCurrentUser();
    }
}
