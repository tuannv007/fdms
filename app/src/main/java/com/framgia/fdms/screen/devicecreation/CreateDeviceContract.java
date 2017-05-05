package com.framgia.fdms.screen.devicecreation;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.source.api.request.RegisterDeviceRequest;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface CreateDeviceContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onDeviceCategoryLoaded(List<Category> categories);

        void onDeviceStatusLoaded(List<Status> statuses);

        void showProgressbar();

        void hideProgressbar();

        void onRegisterError();

        void onRegisterSuccess();

        void onInputProductionNameError();

        void onInputSerialNumberError();

        void onInputModellNumberError();

        void onInputDeviceCodeError();

        void onInputCategoryError();

        void onInputStatusError();

        void onAddImageClick();

        void onCreateDeviceClick();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void registerDevice(RegisterDeviceRequest registerDeviceRequest);

        boolean validateDataInput(RegisterDeviceRequest registerDeviceRequest);
    }
}
