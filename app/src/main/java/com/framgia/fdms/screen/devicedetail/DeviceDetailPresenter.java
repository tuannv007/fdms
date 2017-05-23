package com.framgia.fdms.screen.devicedetail;

/**
 * Listens to user actions from the UI ({@link DeviceDetailActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
final class DeviceDetailPresenter implements DeviceDetailContract.Presenter {
    private static final String TAG = DeviceDetailPresenter.class.getName();

    private final DeviceDetailContract.ViewModel mViewModel;

    public DeviceDetailPresenter(DeviceDetailContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
