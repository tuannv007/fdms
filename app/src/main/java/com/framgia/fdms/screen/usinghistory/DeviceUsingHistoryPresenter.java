package com.framgia.fdms.screen.usinghistory;

/**
 * Listens to user actions from the UI ({@link DeviceUsingHistoryFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
final class DeviceUsingHistoryPresenter implements DeviceUsingHistoryContract.Presenter {

    private final DeviceUsingHistoryContract.ViewModel mViewModel;

    public DeviceUsingHistoryPresenter(DeviceUsingHistoryContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
