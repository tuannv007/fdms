package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.User;
import com.framgia.fdms.data.source.remote.UserRemoteDataSource;
import rx.Observable;

/**
 * Created by levutantuan on 4/4/17.
 */

public class UserRepository {

    private UserRemoteDataSource mUserRemoteDataSource;

    public UserRepository(UserRemoteDataSource remoteDataSource) {
        mUserRemoteDataSource = remoteDataSource;
    }

    public Observable<User> login(String userName, String passWord) {
        return mUserRemoteDataSource.login(userName, passWord);
    }
}
