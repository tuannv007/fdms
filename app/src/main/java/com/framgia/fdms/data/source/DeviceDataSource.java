package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.source.api.request.RegisterDeviceRequest;
import java.util.List;
import rx.Observable;

/**
 * Created by Age on 4/3/2017.
 */
public class DeviceDataSource {
    public interface LocalDataSource {
    }

    public interface RemoteDataSource {
        Observable<List<Device>> getListDevices(int categoryId,int statusId,int page, int perPage);

        Observable<List<Device>> searchDevices(String keyWord);

        Observable<List<Category>> getListCategory();

        Observable<Device> registerdevice(RegisterDeviceRequest registerdevice);
    }
}
