package com.framgia.fdms.screen.device;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.source.api.request.RegisterDeviceRequest;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DeviceContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onDCategoryLoaded(List<Category> categories);

        void showProgressbar();

        void hideProgressbar();

        void onRegisterError();

        void onRegisterSuccess();

        void onInputTitleError();

        void onInputDescriptionError();

        void onInputDeviceNameError();

        void onInputCategoryError();

        void onInputNumberError();
    }

    interface Presenter extends BasePresenter {
        void registerDevice(RegisterDeviceRequest registerDeviceRequest);

        boolean validateDataInput(RegisterDeviceRequest registerDeviceRequest);
    }
}
