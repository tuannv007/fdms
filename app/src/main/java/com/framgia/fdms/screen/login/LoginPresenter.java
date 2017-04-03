package com.framgia.fdms.screen.login;

/**
 * Listens to user actions from the UI ({@link LoginActivity}), retrieves the data and updates
 * the UI as required.
 */
final class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.ViewModel mView;

    public LoginPresenter(LoginContract.ViewModel view) {
        this.mView = view;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
