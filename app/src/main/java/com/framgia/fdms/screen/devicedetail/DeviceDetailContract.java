package com.framgia.fdms.screen.devicedetail;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DeviceDetailContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onEditDevice();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
