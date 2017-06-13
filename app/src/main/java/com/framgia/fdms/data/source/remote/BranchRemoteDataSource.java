package com.framgia.fdms.data.source.remote;

import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.source.BranchDataSource;
import com.framgia.fdms.data.source.api.service.FDMSApi;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

/**
 * Created by MyPC on 13/06/2017.
 */

public class BranchRemoteDataSource extends BaseRemoteDataSource implements BranchDataSource {
    public BranchRemoteDataSource(FDMSApi FDMSApi) {
        super(FDMSApi);
    }

    @Override
    public Observable<List<Status>> getListBranch() {
        // TODO: later
        List<Status> branches = new ArrayList<>();
        branches.add(new Status(1, "Hanoi"));
        branches.add(new Status(2, "Danang"));
        branches.add(new Status(3, "HCM"));
        return Observable.just(branches);
    }
}
