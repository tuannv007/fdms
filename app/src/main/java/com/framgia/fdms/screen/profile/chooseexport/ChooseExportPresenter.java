package com.framgia.fdms.screen.profile.chooseexport;

import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.source.DeviceRepository;
import java.util.List;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static com.framgia.fdms.utils.Constant.FIRST_PAGE;
import static com.framgia.fdms.utils.Constant.NOT_SEARCH;
import static com.framgia.fdms.utils.Constant.OUT_OF_INDEX;
import static com.framgia.fdms.utils.Constant.PER_PAGE;

/**
 * Created by tuanbg on 6/15/17.
 */

public class ChooseExportPresenter implements ChooseExportContract.Presenter {
    private ChooseExportContract.ViewModel mViewModel;
    private DeviceRepository mDeviceRepository;
    private CompositeSubscription mCompositeSubscriptions = new CompositeSubscription();
    private String mKeyWord = NOT_SEARCH;
    private int mCategoryId = OUT_OF_INDEX;
    private int mStatusId = OUT_OF_INDEX;
    private int mPage = FIRST_PAGE;

    public ChooseExportPresenter(ChooseExportContract.ViewModel viewModel,
            DeviceRepository deviceRepository) {
        mViewModel = viewModel;
        mDeviceRepository = deviceRepository;
    }

    @Override
    public void onStart() {
        getListDevice(mKeyWord, mCategoryId, mStatusId, mPage, PER_PAGE);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void getListDevice(String deviceName, int categoryId, int statusId, int page,
            int perPage) {
        Subscription subscription =
                mDeviceRepository.getListDevices(deviceName, categoryId, statusId, page, perPage)
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
}
