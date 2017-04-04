package com.framgia.fdms.data.source.remote;

import com.framgia.fdms.data.model.User;
import com.framgia.fdms.data.source.UserDataSource;
import com.framgia.fdms.data.source.api.request.RegisterRequest;
import com.framgia.fdms.data.source.api.service.FDMSApi;
import rx.Observable;

/**
 * Created by levutantuan on 4/4/17.
 */

public class UserRemoteDataSource implements UserDataSource.RemoteDataSource {
    private FDMSApi mFDMSApi;

    public UserRemoteDataSource(FDMSApi FDMSApi) {
        mFDMSApi = FDMSApi;
    }

    @Override
    public Observable<User> login(String userName, String passWord) {
        // TODO: 4/4/17 replace by call API later
        User user = new User("tuan", "123", "", "", "", "");
        return Observable.just(user);
    }

    @Override
    public Observable<User> register(RegisterRequest request) {
        // TODO: 4/4/17 replace by call API later
        User user = new User(request.getUserName(), request.getFirstName(), request.getLastName(),
                request.getAddress(), request.getDepartment(), request.getRole());
        return Observable.just(user);
    }
}
