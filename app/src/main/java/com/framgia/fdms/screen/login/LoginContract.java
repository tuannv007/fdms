package com.framgia.fdms.screen.login;

import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface LoginContract {

    interface ViewModel extends BaseViewModel<Presenter> {
        void onLoginError();

        void onLoginSuccess();
    }

    interface Presenter extends BasePresenter {
        void login(String userName, String passWord);

        boolean validateDataInput(String username, String password);
    }
}
