package com.framgia.fdms.screen.returndevice;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Status;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ReturnDeviceContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onCheckedChanged(boolean checked, Device device, int position);

        void onClickItemAssigner(Status status, int position);

        void onReturnDevice();

        void showProgressbar();

        void hideProgressbar();

        void onLoadError(String message);

        void onGetAssignedSuccess(List<Status> statuses);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getListAssign();
    }
}
