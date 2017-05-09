package com.framgia.fdms.screen.requestmanager;

import com.framgia.fdms.BaseFragmentContract;
import com.framgia.fdms.data.model.Request;

/**
 * This specifies the contract between the view and the presenter.
 */
interface RequestManagerContract {
    /**
     * View.
     */
    interface ViewModel extends BaseFragmentContract.ViewModel<Request> {

    }

    /**
     * Presenter.
     */
    interface Presenter extends BaseFragmentContract.Presenter<Request> {
    }
}
