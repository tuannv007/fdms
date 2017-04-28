package com.framgia.fdms.data.source.remote;

import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Picture;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.source.DeviceDataSource;
import com.framgia.fdms.data.source.api.request.RegisterDeviceRequest;
import com.framgia.fdms.data.source.api.service.FDMSApi;
import com.framgia.fdms.data.source.api.service.ServiceClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.http.Query;
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
                        if (listRespone == null) {
                            return Observable.error(new NullPointerException());
                        } else if (listRespone.isError()) {
                            return Observable.error(
                                    new NullPointerException("ERROR" + listRespone.getStatus()));
                        } else {
                            return Observable.just(listRespone.getData());
                        }
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
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Laptop"));
        categories.add(new Category("CPU"));
        categories.add(new Category("IPad"));
        categories.add(new Category("Mouse"));
        categories.add(new Category("Keyboard"));
        return Observable.just(categories);
    }

    @Override
    public Observable<Device> registerdevice(RegisterDeviceRequest registerdevice) {
        // TODO: 4/4/17 replace by call API later
        return null;
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
