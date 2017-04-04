package com.framgia.fdms.screen.login;

import android.content.Context;
import android.content.Intent;
import com.framgia.fdms.screen.main.MainActivity;

/**
 * Exposes the data to be used in the Login screen.
 */
public class LoginViewModel implements LoginContract.ViewModel {
    private Context mContext;
    private LoginContract.Presenter mPresenter;
    private String mUsername;
    private String mPassword;

    public LoginViewModel(Context context) {
        mContext = context;
    }

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
        mContext.startActivity(new Intent(mContext, MainActivity.class));
    }

    public void onForgotPasswordClick() {
        //TODO Forgot Password Activity
    }

    public void onSignUpClick() {
        //TODO SignUp Activity
    }

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
