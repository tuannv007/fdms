package com.framgia.fdms.data.source.remote;

import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.source.RequestDataSource;
import com.framgia.fdms.data.source.api.service.FDMSApi;
import java.util.List;
import rx.Observable;

/**
 * Created by MyPC on 10/05/2017.
 */

public class RequestRemoteDataSource extends BaseRemoteDataSource
        implements RequestDataSource.RemoteDataSource {
    public RequestRemoteDataSource(FDMSApi FDMSApi) {
        super(FDMSApi);
    }

    @Override
    public Observable<Respone<List<Dashboard>>> getRequestDashboard() {
        return mFDMSApi.getDashboardRequest();
    }
}
