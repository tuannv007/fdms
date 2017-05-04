package com.framgia.fdms.screen.devicecreation;

import android.text.TextUtils;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.source.DeviceRepository;
import com.framgia.fdms.data.source.api.request.RegisterDeviceRequest;
import java.util.List;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Listens to user actions from the UI ({@link CreateDeviceActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
final class CreateDevicePresenter implements CreateDeviceContract.Presenter {
    private final CreateDeviceContract.ViewModel mViewModel;
    private CompositeSubscription mCompositeSubscription;
    private DeviceRepository mDeviceRepository;
    private RegisterDeviceRequest mRequest;

    public CreateDevicePresenter(CreateDeviceContract.ViewModel viewModel, DeviceRepository repository) {
        mViewModel = viewModel;
        mDeviceRepository = repository;
        mRequest = new RegisterDeviceRequest();
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {
        getListCategories();
        getListStatuses();
    }

    @Override
    public void onStop() {
        mCompositeSubscription.clear();
    }

    @Override
    public void registerDevice(RegisterDeviceRequest registerDeviceRequest) {
        if (!validateDataInput(registerDeviceRequest)) {
            return;
        }
        Subscription subscription = mDeviceRepository.registerdevice(mRequest)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<Device>() {
                    @Override
                    public void call(Device deviceRequest) {
                        mViewModel.onRegisterSuccess();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mViewModel.onRegisterError();
                    }
                });
        mCompositeSubscription.add(subscription);
    }

    public void getListCategories() {
        Subscription subscription = mDeviceRepository.getListCategory()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mViewModel.showProgressbar();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Category>>() {
                    @Override
                    public void call(List<Category> categories) {
                        mViewModel.onDeviceCategoryLoaded(categories);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mViewModel.onInputCategoryError();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        mViewModel.hideProgressbar();
                    }
                });
        mCompositeSubscription.add(subscription);
    }

    public void getListStatuses() {
        Subscription subscription = mDeviceRepository.getListStatus()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mViewModel.showProgressbar();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Status>>() {
                    @Override
                    public void call(List<Status> statuses) {
                        mViewModel.onDeviceStatusLoaded(statuses);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mViewModel.onInputStatusError();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        mViewModel.hideProgressbar();
                    }
                });
        mCompositeSubscription.add(subscription);
    }

    @Override
    public boolean validateDataInput(RegisterDeviceRequest registerDeviceRequest) {
        boolean isValid = true;
        if (TextUtils.isEmpty(registerDeviceRequest.getDeviceCode())) {
            isValid = false;
            mViewModel.onInputDeviceCodeError();
        }
        if (TextUtils.isEmpty(registerDeviceRequest.getModellNumber())) {
            isValid = false;
            mViewModel.onInputModellNumberError();
        }
        if (TextUtils.isEmpty(registerDeviceRequest.getProductionName())) {
            isValid = false;
            mViewModel.onInputProductionNameError();
        }
        if (TextUtils.isEmpty(registerDeviceRequest.getSerialNumber())) {
            isValid = false;
            mViewModel.onInputSerialNumberError();
        }
        return isValid;
    }
}
