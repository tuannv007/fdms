package com.framgia.fdms.screen.register;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface RegisterContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<RegisterContract.Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
