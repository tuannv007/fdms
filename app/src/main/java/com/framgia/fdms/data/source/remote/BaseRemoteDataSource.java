package com.framgia.fdms.data.source.remote;

import com.framgia.fdms.data.source.api.service.FDMSApi;

public abstract class BaseRemoteDataSource {
    private FDMSApi mFDMSApi;

    public BaseRemoteDataSource(FDMSApi FDMSApi) {
        mFDMSApi = FDMSApi;
    }
}
