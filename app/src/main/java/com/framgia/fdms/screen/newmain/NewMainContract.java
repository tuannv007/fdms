package com.framgia.fdms.screen.newmain;

import android.content.Intent;
import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Device;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface NewMainContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void getResult(String resultQrCode);

        void onActivityResult(int requestCode, int resultCode, Intent data);

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
