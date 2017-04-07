package com.framgia.fdms.screen.main;

import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.source.DeviceRepository;
import java.util.List;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Listens to user actions from the UI ({@link MainActivity}), retrieves the data and updates
 * the UI as required.
 */
final class MainPresenter implements MainContract.Presenter {
    private static final String TAG = MainPresenter.class.getName();
    private final MainContract.ViewModel mViewModel;
    private DeviceRepository mDeviceRepository;
    private CompositeSubscription mCompositeSubscriptions = new CompositeSubscription();

    MainPresenter(MainContract.ViewModel viewModel, DeviceRepository deviceRepository) {
        mViewModel = viewModel;
        mDeviceRepository = deviceRepository;
    }

    @Override
    public void onStart() {
        getListDevice();
    }

    @Override
    public void onStop() {
        mCompositeSubscriptions.clear();
    }

    public void getListDevice() {
        Subscription subscription = mDeviceRepository.getListDevice()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mViewModel.showProgressbar();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Device>>() {
                    @Override
                    public void call(List<Device> devices) {
                        mViewModel.onDeviceLoaded(devices);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mViewModel.onError();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        mViewModel.hideProgressbar();
                    }
                });
        mCompositeSubscriptions.add(subscription);
    }
}
