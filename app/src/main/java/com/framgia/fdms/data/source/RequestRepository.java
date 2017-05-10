package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.source.remote.RequestRemoteDataSource;
import java.util.List;
import rx.Observable;

/**
 * Created by MyPC on 10/05/2017.
 */

public class RequestRepository {
    private RequestRemoteDataSource mRequestRemoteDataSource;

    public RequestRepository(RequestRemoteDataSource requestRemoteDataSource) {
        mRequestRemoteDataSource = requestRemoteDataSource;
    }

    public Observable<Respone<List<Dashboard>>> getRequestDashboard() {
        return mRequestRemoteDataSource.getRequestDashboard();
    }
}
