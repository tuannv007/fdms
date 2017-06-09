package com.framgia.fdms.screen.assignment;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface AssignmentContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onAddItemClick();

        void onAssignClick();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
