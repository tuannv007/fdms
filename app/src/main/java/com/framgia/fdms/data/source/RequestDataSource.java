package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Respone;
import java.util.List;
import rx.Observable;

/**
 * Created by MyPC on 10/05/2017.
 */

public class RequestDataSource {
    public interface LocalDataSource {
    }

    public interface RemoteDataSource {
        Observable<Respone<List<Dashboard>>> getRequestDashboard();
    }
}
