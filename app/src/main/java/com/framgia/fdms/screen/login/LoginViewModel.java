package com.framgia.fdms.screen.login;

/**
 * Exposes the data to be used in the Login screen.
 */
public class LoginViewModel implements LoginContract.ViewModel {
    private LoginContract.Presenter mPresenter;
    private String mUsername;
    private String mPassword;

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void onLoginClick() {
        //TODO Login
    }

    ;

    public void onForgotPasswordClick() {
        //TODO Forgot Password Activity
    }

    ;

    public void onSignUpClick() {
        //TODO SignUp Activity
    }

    ;

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
