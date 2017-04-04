package com.framgia.fdms.data;

import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.source.DeviceRemoteDataSource;
import java.util.List;
import rx.Observable;

public class DeviceRepository {
    private DeviceRemoteDataSource mDeviceRemoteDataSource;

    public DeviceRepository(DeviceRemoteDataSource remoteDataSource) {
        mDeviceRemoteDataSource = remoteDataSource;
    }

    public Observable<List<Device>> getListDevice() {
        return mDeviceRemoteDataSource.getListDevice();
    }
}
