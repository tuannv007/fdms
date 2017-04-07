package com.framgia.fdms.screen.device;

import com.framgia.fdms.data.source.DeviceRepository;
import rx.subscriptions.CompositeSubscription;

/**
 * Listens to user actions from the UI ({@link DeviceActivity}), retrieves the data and updates
 * the UI as required.
 */
final class DevicePresenter implements DeviceContract.Presenter {
    private final DeviceContract.ViewModel mViewModel;
    private CompositeSubscription mCompositeSubscription;
    private DeviceRepository mDeviceRepository;

    public DevicePresenter(DeviceContract.ViewModel viewModel, DeviceRepository repository) {
        mViewModel = viewModel;
        mDeviceRepository = repository;
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {
        //TODO dev later
    }

    @Override
    public void onStop() {
        mCompositeSubscription.clear();
    }
}
