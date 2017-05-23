package com.framgia.fdms.data.source;

import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.DeviceUsingHistory;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.model.Status;
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
        Observable<List<Device>> getListDevices(String deviceName, int categoryId, int statusId,
                int page, int perPage);

        Observable<List<Device>> searchDevices(String keyWord);

        Observable<List<Category>> getListCategory();

        Observable<List<Status>> getListStatus();

        Observable<Device> registerdevice(RegisterDeviceRequest registerdevice);

        Observable<Device> getDeviceByQrCode(String qrCode);

        Observable<List<Dashboard>> getDashboardDevice();

        Observable<List<DeviceUsingHistory>> getDeviceUsingHistory(int deviceId);
    }
}
