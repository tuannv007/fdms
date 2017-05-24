package com.framgia.fdms.screen.main;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Device;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface MainContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void getResult(String resultQrCode);

        void onGetDecodeSuccess(Device device);

        void onGetDeviceError(String error);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getDevice(String resultQrCode);
    }
}
