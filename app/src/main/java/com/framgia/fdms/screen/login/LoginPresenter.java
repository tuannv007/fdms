package com.framgia.fdms.screen.login;

import android.databinding.BaseObservable;
import android.text.TextUtils;
import com.framgia.fdms.data.model.User;
import com.framgia.fdms.data.source.UserRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Listens to user actions from the UI ({@link LoginActivity}), retrieves the data and updates
 * the UI as required.
 */
final class LoginPresenter extends BaseObservable implements LoginContract.Presenter {

    private LoginContract.ViewModel mView;
    private UserRepository mUserRepository;

    public LoginPresenter(LoginContract.ViewModel view, UserRepository userRepository) {
        this.mView = view;
        mUserRepository = userRepository;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void login(String userName, String passWord) {
        mUserRepository.login(userName, passWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        mView.onLoginSuccess();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.onLoginError();
                    }
                });
    }

    @Override
    public boolean validateDataInput(String username, String password) {
        boolean isValid = true;
        if (TextUtils.isEmpty(username)) {
            isValid = false;
            mView.onInputUserNameError();
        }
        if (TextUtils.isEmpty(password)) {
            isValid = false;
            mView.onInputPasswordError();
        }
        return isValid;
    }
}
