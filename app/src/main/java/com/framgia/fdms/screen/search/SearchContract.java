package com.framgia.fdms.screen.search;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Device;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface SearchContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void searchDevicesSuccess(List<Device> devices);

        void onSearchDevicesError();

        void showProgressbar();

        void hideProgressbar();

        void onClickSearch();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void searchDevice(String keyWork);
    }
}
