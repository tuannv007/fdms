package com.framgia.fdms.screen.newmain;

import com.framgia.fdms.data.model.Device;

/**
 * Listens to user actions from the UI ({@link NewMainActivity}), retrieves the data and updates
 * the UI as required.
 */
final class NewMainPresenter implements NewMainContract.Presenter {
    private static final String TAG = NewMainPresenter.class.getName();
    private final NewMainContract.ViewModel mViewModel;

    public NewMainPresenter(NewMainContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public Device getDevice(String resultQrCode) {
        //todo get device from result of Qr Code 
        return null;
    }
}
