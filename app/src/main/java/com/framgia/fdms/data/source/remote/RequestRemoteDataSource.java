package com.framgia.fdms.data.source.remote;

import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.source.RequestDataSource;
import com.framgia.fdms.data.source.api.service.FDMSApi;
import com.framgia.fdms.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;

import static com.framgia.fdms.utils.Constant.ALL_RELATIVE_ID;
import static com.framgia.fdms.utils.Constant.ALL_REQUEST_STATUS_ID;
import static com.framgia.fdms.utils.Constant.ApiParram.PAGE;
import static com.framgia.fdms.utils.Constant.ApiParram.PER_PAGE;
import static com.framgia.fdms.utils.Constant.ApiParram.RELATIVE_ID;
import static com.framgia.fdms.utils.Constant.ApiParram.REQUEST_STATUS_ID;
import static com.framgia.fdms.utils.Constant.OUT_OF_INDEX;

/**
 * Created by beepi on 11/05/2017.
 */

public class RequestRemoteDataSource extends BaseRemoteDataSource
        implements RequestDataSource.RemoteDataSource {
    private FDMSApi mFDMSApi;

    public RequestRemoteDataSource(FDMSApi FDMSApi) {
        super(FDMSApi);
        mFDMSApi = FDMSApi;
    }

    @Override
    public Observable<List<Request>> getMyRequest(int requestStatusId, int relativeId, int perPage,
            int page) {
        return mFDMSApi.getMyRequest(getRequestParams(requestStatusId, relativeId, page, perPage))
                .flatMap(new Func1<Respone<List<Request>>, Observable<List<Request>>>() {
                    @Override
                    public Observable<List<Request>> call(Respone<List<Request>> listRespone) {
                        return Utils.getResponse(listRespone);
                    }
                });
    }

    @Override
    public Observable<List<Status>> getStatus() {
        List<Status> status = new ArrayList<>();
        return Observable.just(status);
    }

    @Override
    public Observable<List<Dashboard>> getDashboardRequest() {
        // TODO: later 
        List<Dashboard> dashboards = new ArrayList<>();
        dashboards.add(new Dashboard("watting", 22, "aero", "#BDC3C7", "#CFD4D8"));
        dashboards.add(new Dashboard("available", 35, "purple", "#9B59B6", "#B370CF"));
        dashboards.add(new Dashboard("broken", 15, "red", "#E74C3C", "#E95E4F"));
        return Observable.just(dashboards);
    }

    private Map<String, Integer> getRequestParams(int requestStatusId, int relativeId, int page,
            int perPage) {
        Map<String, Integer> parrams = new HashMap<>();
        if (requestStatusId != ALL_REQUEST_STATUS_ID) {
            parrams.put(REQUEST_STATUS_ID, requestStatusId);
        }
        if (relativeId != ALL_RELATIVE_ID) {
            parrams.put(RELATIVE_ID, relativeId);
        }
        if (perPage != OUT_OF_INDEX) {
            parrams.put(PER_PAGE, perPage);
        }
        if (page != OUT_OF_INDEX) {
            parrams.put(PAGE, page);
        }
        return parrams;
    }
}
