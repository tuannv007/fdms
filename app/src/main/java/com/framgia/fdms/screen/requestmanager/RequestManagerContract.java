package com.framgia.fdms.screen.requestmanager;

import com.framgia.fdms.BaseFragmentContract;
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
    interface ViewModel extends BaseFragmentContract.ViewModel<Request> {
        void onGetRequestSuccess(List<Request> requests);

        void onGetStatusSuccess(List<Status> statuses);

        void onGetRelativeSuccess(List<Status> relatives);

        void onLoadError(String msg);

        void getData();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BaseFragmentContract.Presenter<Request> {
        void getMyRequest(int requestStatusId, int relativeId, int perPage, int page);

        void getStatusDevice();

        void getListRelative();
    }
}
