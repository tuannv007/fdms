package com.framgia.fdms.screen.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.fdms.R;
import com.framgia.fdms.screen.main.MainActivity;

/**
 * Exposes the data to be used in the Login screen.
 */
public class LoginViewModel extends BaseObservable implements LoginContract.ViewModel {

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

    @Override
    public void onLoginError() {
        Toast.makeText(mContext, R.string.msg_login_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        mContext.startActivity(new Intent(mContext, MainActivity.class));
    }

    public void onLoginClick() {
        if (!mPresenter.validateDataInput(mUsername, mPassword)) {
            Toast.makeText(mContext, R.string.msg_please_input_text, Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.login(mUsername, mPassword);
    }

    public void onForgotPasswordClick() {
        //TODO Forgot Password Activity
    }

    public void onSignUpClick() {
        //TODO SignUp Activity
    }

    @Bindable
    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
