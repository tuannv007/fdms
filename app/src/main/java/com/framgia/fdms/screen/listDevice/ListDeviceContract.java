package com.framgia.fdms.screen.listDevice;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Status;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface ListDeviceContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onDeviceLoaded(List<Device> devices);

        void onDeviceClick(Device device);

        void showProgressbar();

        void onError(String msg);

        void hideProgressbar();

        void onRegisterDeviceClick();

        void onDeviceCategoryLoaded(List<Category> categories);

        void onDeviceStatusLoaded(List<Status> statuses);

        void onSearch();

        void onChooseCategory();

        void onChooseStatus();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void loadMoreData();

        void searchDevices(String keyWord, int categoryId, int statusId);
    }
}
