package com.framgia.fdms.screen.historydetail;

/**
 * Listens to user actions from the UI ({@link DeviceDetailHistoryFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
public final class DeviceDetailHistoryPresenter implements DeviceDetailHistoryContract.Presenter {
    private static final String TAG = DeviceDetailHistoryPresenter.class.getName();

    private final DeviceDetailHistoryContract.ViewModel mViewModel;

    public DeviceDetailHistoryPresenter(DeviceDetailHistoryContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
