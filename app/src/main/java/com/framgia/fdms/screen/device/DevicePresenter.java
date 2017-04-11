package com.framgia.fdms.screen.device;

import android.text.TextUtils;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Device;
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
 * Listens to user actions from the UI ({@link DeviceActivity}), retrieves the data and updates
 * the UI as required.
 */
final class DevicePresenter implements DeviceContract.Presenter {
    private final DeviceContract.ViewModel mViewModel;
    private CompositeSubscription mCompositeSubscription;
    private DeviceRepository mDeviceRepository;
    private RegisterDeviceRequest mRequest;

    public DevicePresenter(DeviceContract.ViewModel viewModel, DeviceRepository repository) {
        mViewModel = viewModel;
        mDeviceRepository = repository;
        mRequest = new RegisterDeviceRequest();
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {
        getListCategories();
    }

    @Override
    public void onStop() {
        mCompositeSubscription.clear();
    }

    @Override
    public void registerDevice(RegisterDeviceRequest deviceRequest) {
        if (!validateDataInput(deviceRequest)) {
            return;
        }
        Subscription subscription = mDeviceRepository.registerdevice(mRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                        mViewModel.onDCategoryLoaded(categories);
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

    @Override
    public boolean validateDataInput(RegisterDeviceRequest deviceRequest) {
        boolean isValid = true;
        if (TextUtils.isEmpty(deviceRequest.getTitle())) {
            isValid = false;
            mViewModel.onInputTitleError();
        }
        if (TextUtils.isEmpty(deviceRequest.getDescription())) {
            isValid = false;
            mViewModel.onInputDescriptionError();
        }
        if (TextUtils.isEmpty(deviceRequest.getDeviceName())) {
            isValid = false;
            mViewModel.onInputDeviceNameError();
        }
        if (TextUtils.isEmpty(deviceRequest.getCategory())) {
            isValid = true;
            mViewModel.onInputCategoryError();
        }
        if (TextUtils.isEmpty(deviceRequest.getNumber())) {
            isValid = false;
            mViewModel.onInputNumberError();
        }
        return isValid;
    }
}
