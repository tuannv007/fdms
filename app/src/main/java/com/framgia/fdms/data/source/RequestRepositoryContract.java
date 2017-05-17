package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.model.Status;
import java.util.List;
import rx.Observable;

/**
 * Created by beepi on 11/05/2017.
 */

public interface RequestRepositoryContract {
    /**
     * Use on remote request to get list request
     */
    Observable<List<Request>> getMyRequest(int requestStatusId, int relativeId, int perPage,
            int page);

    Observable<List<Status>> getStatus();

    Observable<List<Dashboard>> getDashboardRequest();
}
