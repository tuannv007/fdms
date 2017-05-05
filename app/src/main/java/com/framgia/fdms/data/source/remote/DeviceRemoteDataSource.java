package com.framgia.fdms.data.source.remote;

import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.source.DeviceDataSource;
import com.framgia.fdms.data.source.api.request.RegisterDeviceRequest;
import com.framgia.fdms.data.source.api.service.FDMSApi;
import com.framgia.fdms.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;

import static com.framgia.fdms.utils.Constant.ApiParram.CATEGORY_ID;
import static com.framgia.fdms.utils.Constant.ApiParram.PAGE;
import static com.framgia.fdms.utils.Constant.ApiParram.PER_PAGE;
import static com.framgia.fdms.utils.Constant.ApiParram.STATUS_ID;
import static com.framgia.fdms.utils.Constant.OUT_OF_INDEX;

public class DeviceRemoteDataSource implements DeviceDataSource.RemoteDataSource {

    private FDMSApi mFDMSApi;

    public DeviceRemoteDataSource(FDMSApi FDMSApi) {
        mFDMSApi = FDMSApi;
    }

    @Override
    public Observable<List<Device>> getListDevices(int categoryId, int statusId, int page,
            int perPage) {

        return mFDMSApi.getListDevices(getDeviceParams(categoryId, statusId, page, perPage))
                .flatMap(new Func1<Respone<List<Device>>, Observable<List<Device>>>() {
                    @Override
                    public Observable<List<Device>> call(Respone<List<Device>> listRespone) {
                        return Utils.getResponse(listRespone);
                    }
                });
    }

    @Override
    public Observable<List<Device>> searchDevices(String keyWord) {
        List<Device> devices = new ArrayList<>();

        return Observable.just(devices);
    }

    @Override
    public Observable<List<Category>> getListCategory() {
        // TODO: replace by call API later
        List<Category> categories = new ArrayList<>();
        return Observable.just(categories);
    }

    @Override
    public Observable<List<Status>> getListStatus() {
        // TODO: replace by call API later
        List<Status> statuses = new ArrayList<>();
        return Observable.just(statuses);
    }

    @Override
    public Observable<Device> registerdevice(RegisterDeviceRequest registerdevice) {
        // TODO: 4/4/17 replace by call API later
        return null;
    }

    @Override
    public Observable<Device> getDeviceByQrCode(String qrCode) {
        // todo connect server to get device by qr code
        return Observable.just(new Device());
    }

    public Map<String, String> getDeviceParams(int categoryId, int statusId, int page,
            int perPage) {
        Map<String, String> parrams = new HashMap<>();
        if (categoryId != OUT_OF_INDEX) {
            parrams.put(CATEGORY_ID, String.valueOf(categoryId));
        }
        if (statusId != OUT_OF_INDEX) {
            parrams.put(STATUS_ID, String.valueOf(statusId));
        }

        if (page != OUT_OF_INDEX) {
            parrams.put(PAGE, String.valueOf(page));
        }
        if (perPage != OUT_OF_INDEX) {
            parrams.put(PER_PAGE, String.valueOf(perPage));
        }
        return parrams;
    }
}
