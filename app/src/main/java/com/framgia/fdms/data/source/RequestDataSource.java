package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.model.Respone;
import java.util.List;
import rx.Observable;

/**
 * Created by beepi on 11/05/2017.
 */

public interface RequestDataSource {
    interface LocalDataSource {
    }

    interface RemoteDataSource {
        Observable<List<Dashboard>> getDashboardRequest();

        Observable<List<Request>> getMyRequest(int requestStatusId, int relativeId, int perPage,
                int page);
    }
}
