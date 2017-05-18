package com.framgia.fdms.screen.requestcreation;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Status;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface RequestCreationContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onRelativeClick();

        void onAssigneeClick();

        void onCreateRequestClick();

        void onGetAssignedSuccess(List<Status> assignees);

        void onGetRelativeSuccess(List<Status> relatives);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
