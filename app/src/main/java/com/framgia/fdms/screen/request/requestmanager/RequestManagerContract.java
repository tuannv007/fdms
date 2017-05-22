package com.framgia.fdms.screen.request.requestmanager;

import com.framgia.fdms.BaseFragmentContract;
import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.model.Status;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface RequestManagerContract {
    /**
     * View.
     */
    interface ViewModel extends BaseFragmentContract.ViewModel {
        void onGetRequestSuccess(List<Request> requests);

        void onGetStatusSuccess(List<Status> statuses);

        void onGetRelativeSuccess(List<Status> relatives);

        void onLoadError(String msg);

        void getData();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BaseFragmentContract.Presenter {
        void getRequest(int requestStatusId, int relativeId, int perPage, int page);

        void getStatusDevice();

        void getListRelative();
    }
}
