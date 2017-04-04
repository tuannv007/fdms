package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.User;
import rx.Observable;

/**
 * Created by levutantuan on 4/4/17.
 */

public class UserDataSource {

    public interface LocalDataSource {
    }

    public interface RemoteDataSource {
        Observable<User> login(String userName, String passWord);
    }
}
