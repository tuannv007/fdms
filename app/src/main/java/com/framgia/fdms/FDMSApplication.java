package com.framgia.fdms;

import android.app.Application;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;

/**
 * Created by Age on 4/3/2017.
 */
public class FDMSApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FDMSServiceClient.initialize(this);
    }
}
