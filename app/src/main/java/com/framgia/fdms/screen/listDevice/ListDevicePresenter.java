package com.framgia.fdms.screen.listDevice;

import android.util.Log;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.source.DeviceRepository;
import java.util.List;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static com.framgia.fdms.utils.Constant.FIRST_PAGE;
import static com.framgia.fdms.utils.Constant.OUT_OF_INDEX;
import static com.framgia.fdms.utils.Constant.PER_PAGE;

/**
 * Listens to user actions from the UI ({@link ListDeviceFragment}), retrieves the data and updates
 * the UI as required.
 */
final class ListDevicePresenter implements ListDeviceContract.Presenter {
    private CompositeSubscription mCompositeSubscriptions = new CompositeSubscription();
    private int mPage = FIRST_PAGE;

    private final ListDeviceContract.ViewModel mViewModel;
    private DeviceRepository mDeviceRepository;

    public ListDevicePresenter(ListDeviceContract.ViewModel viewModel,
            DeviceRepository deviceRepository) {
        mViewModel = viewModel;
        mDeviceRepository = deviceRepository;
    }

    @Override
    public void onStart() {
        getListDevice(OUT_OF_INDEX, OUT_OF_INDEX, mPage, PER_PAGE);
    }

    @Override
    public void onStop() {
        mCompositeSubscriptions.clear();
    }

    public void getListDevice(int categoryId, int statusId, int page, int perPage) {
        Subscription subscription =
                mDeviceRepository.getListDevices(categoryId, statusId, page, perPage)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {
                                mViewModel.showProgressbar();
                            }
                        })
                        .subscribe(new Subscriber<List<Device>>() {
                            @Override
                            public void onCompleted() {
                                    mViewModel.hideProgressbar();
                            }

                            @Override
                            public void onError(Throwable e) {
                                mViewModel.onError(e.getCause().getMessage());
                            }

                            @Override
                            public void onNext(List<Device> devices) {
                                mViewModel.onDeviceLoaded(devices);
                            }
                        });
        mCompositeSubscriptions.add(subscription);
    }

    @Override
    public void loadMoreData() {
        mPage++;
        getListDevice(OUT_OF_INDEX, OUT_OF_INDEX, mPage, PER_PAGE);
    }

    @Override
    public void searchDevices(String keyWord, int categoryId, int statusId) {
        // TODO: 16/05/2017
    }
}
