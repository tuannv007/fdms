package com.framgia.fdms.screen.search;

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
 * Listens to user actions from the UI ({@link SearchActivity}), retrieves the data and updates
 * the UI as required.
 */
final class SearchPresenter implements SearchContract.Presenter {
    private static final String TAG = SearchPresenter.class.getName();
    private final SearchContract.ViewModel mViewModel;
    private CompositeSubscription mCompositeSubscriptions = new CompositeSubscription();
    private DeviceRepository mDeviceRepository;

    SearchPresenter(SearchContract.ViewModel viewModel, DeviceRepository deviceRepository) {
        mViewModel = viewModel;
        mDeviceRepository = deviceRepository;
    }

    @Override
    public void onStart() {
        //TODO dev later
    }

    @Override
    public void onStop() {
        mCompositeSubscriptions.clear();
    }

    @Override
    public void searchDevice(String keyWord) {
        Subscription subscription = mDeviceRepository.searchDevices(keyWord).
                subscribeOn(Schedulers.io()).
                doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mViewModel.showProgressbar();
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<Device>>() {
            @Override
            public void call(List<Device> devices) {
                mViewModel.searchDevicesSuccess(devices);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mViewModel.onSearchDevicesError();
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
