package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.model.Respone;
import java.util.List;
import rx.Observable;

/**
 * Created by beepi on 11/05/2017.
 */

public class RequestRepository implements RequestRepositoryContract {
    private RequestDataSource.RemoteDataSource mRemoteDataSource;
    private static RequestRepository requestRepository;

    public static RequestRepository getInstant(
            RequestDataSource.RemoteDataSource remoteDataSource) {
        if (requestRepository == null) {
            requestRepository = new RequestRepository(remoteDataSource);
        }
        return requestRepository;
    }

    private RequestRepository(RequestDataSource.RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Request>> getMyRequest(int requestStatusId, int relativeId, int perPage,
            int page) {
        return mRemoteDataSource.getMyRequest(requestStatusId, relativeId, perPage, page);
    }

    @Override
    public Observable<Respone<List<Dashboard>>> getDashboardRequest() {
        return mRemoteDataSource.getDashboardRequest();
    }
}
