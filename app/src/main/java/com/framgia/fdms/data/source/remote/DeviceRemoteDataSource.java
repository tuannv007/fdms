package com.framgia.fdms.data.source.remote;

import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.DeviceHistoryDetail;
import com.framgia.fdms.data.model.DeviceUsingHistory;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.source.DeviceDataSource;
import com.framgia.fdms.data.source.api.request.RegisterDeviceRequest;
import com.framgia.fdms.data.source.api.service.FDMSApi;
import com.framgia.fdms.utils.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.functions.Func1;

import static com.framgia.fdms.utils.Constant.ApiParram.CATEGORY_ID;
import static com.framgia.fdms.utils.Constant.ApiParram.DEVICE_CATEGORY_ID;
import static com.framgia.fdms.utils.Constant.ApiParram.DEVICE_CODE;
import static com.framgia.fdms.utils.Constant.ApiParram.DEVICE_NAME;
import static com.framgia.fdms.utils.Constant.ApiParram.DEVICE_STATUS_ID;
import static com.framgia.fdms.utils.Constant.ApiParram.MODEL_NUMBER;
import static com.framgia.fdms.utils.Constant.ApiParram.PAGE;
import static com.framgia.fdms.utils.Constant.ApiParram.PER_PAGE;
import static com.framgia.fdms.utils.Constant.ApiParram.PICTURE;
import static com.framgia.fdms.utils.Constant.ApiParram.PRODUCTION_NAME;
import static com.framgia.fdms.utils.Constant.ApiParram.SERIAL_NUMBER;
import static com.framgia.fdms.utils.Constant.ApiParram.STATUS_ID;
import static com.framgia.fdms.utils.Constant.NOT_SEARCH;
import static com.framgia.fdms.utils.Constant.OUT_OF_INDEX;

public class DeviceRemoteDataSource implements DeviceDataSource.RemoteDataSource {

    private FDMSApi mFDMSApi;

    public DeviceRemoteDataSource(FDMSApi FDMSApi) {
        mFDMSApi = FDMSApi;
    }

    @Override
    public Observable<List<Device>> getListDevices(String deviceName, int categoryId, int statusId,
            int page, int perPage) {

        return mFDMSApi.getListDevices(
                getDeviceParams(deviceName, categoryId, statusId, page, perPage))
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
        Map<String, RequestBody> parrams = new HashMap<>();

        RequestBody productionName = createPartFromString(registerdevice.getProductionName());
        RequestBody deviceStatusId =
                createPartFromString(String.valueOf(registerdevice.getDeviceStatusId()));
        RequestBody deviceCategoryId =
                createPartFromString(String.valueOf(registerdevice.getDeviceStatusId()));
        RequestBody serialNumber = createPartFromString(registerdevice.getSerialNumber());
        RequestBody modellNumber = createPartFromString(registerdevice.getModellNumber());
        RequestBody deviceCode = createPartFromString(registerdevice.getDeviceCode());

        parrams.put(PRODUCTION_NAME, productionName);
        parrams.put(DEVICE_STATUS_ID, deviceStatusId);
        parrams.put(DEVICE_CATEGORY_ID, deviceCategoryId);
        parrams.put(SERIAL_NUMBER, serialNumber);
        parrams.put(MODEL_NUMBER, modellNumber);
        parrams.put(DEVICE_CODE, deviceCode);

        MultipartBody.Part filePart = null;

        if (registerdevice.getFilePath() != null) {
            File file = new File(registerdevice.getFilePath());

            if (file.exists()) {
                RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);

                filePart = MultipartBody.Part.createFormData(PICTURE, file.getName(), requestBody);
            }
        }

        return mFDMSApi.uploadDevice(parrams, filePart)
                .flatMap(new Func1<Respone<Device>, Observable<Device>>() {
                    @Override
                    public Observable<Device> call(Respone<Device> deviceRespone) {
                        return Utils.getResponse(deviceRespone);
                    }
                });
    }

    @Override
    public Observable<Device> getDeviceByQrCode(String qrCode) {
        return mFDMSApi.getDeviceByQrCode(qrCode)
                .flatMap(new Func1<Respone<Device>, Observable<Device>>() {
                    @Override
                    public Observable<Device> call(Respone<Device> deviceRespone) {
                        return Utils.getResponse(deviceRespone);
                    }
                });
    }

    @Override
    public Observable<List<Dashboard>> getDashboardDevice() {
        // TODO: later
        List<Dashboard> dashboards = new ArrayList<>();
        dashboards.add(new Dashboard("using", 398, "aero", "#BDC3C7", "#CFD4D8"));
        dashboards.add(new Dashboard("available", 35, "purple", "#9B59B6", "#B370CF"));
        dashboards.add(new Dashboard("broken", 0, "red", "#E74C3C", "#E95E4F"));
        return Observable.just(dashboards);
    }

    @Override
    public Observable<List<DeviceUsingHistory>> getDeviceUsingHistory(int deviceId) {
        // TODO: 23/05/2017 later
        List<DeviceUsingHistory> tempList = new ArrayList<>();
        tempList.add(new DeviceUsingHistory("Doan Van Toan 0", "20/10/2016", "Now"));
        tempList.add(new DeviceUsingHistory("Doan Van Toan 1", "20/7/2016", "19/10/2016"));
        tempList.add(new DeviceUsingHistory("Doan Van Toan 2", "20/6/2016", "19/7/2016"));
        tempList.add(new DeviceUsingHistory("Doan Van Toan 3", "01/01/2016", "01/05/2016"));
        return Observable.just(tempList);
    }

    @Override
    public Observable<List<DeviceHistoryDetail>> getDeviceDetailHistory(int deviceId) {
        // TODO: 23/05/2017 later
        List<DeviceHistoryDetail> tempList = new ArrayList<>();
        tempList.add(new DeviceHistoryDetail("20/10/2016", "Doan Van Toan 0", "Chu Anh Tuan 0"));
        tempList.add(new DeviceHistoryDetail("21/10/2016", "Doan Van Toan 1", "Chu Anh Tuan 1"));
        tempList.add(new DeviceHistoryDetail("22/10/2016", "Doan Van Toan 2", "Chu Anh Tuan 2"));
        tempList.add(new DeviceHistoryDetail("23/10/2016", "Doan Van Toan 3", "Chu Anh Tuan 3"));
        tempList.add(new DeviceHistoryDetail("24/10/2016", "Doan Van Toan 4", "Chu Anh Tuan 4"));
        return Observable.just(tempList);
    }

    public Map<String, String> getDeviceParams(String deviceName, int categoryId, int statusId,
            int page, int perPage) {
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
        if (!deviceName.equals(NOT_SEARCH)) {
            parrams.put(DEVICE_NAME, deviceName);
        }
        return parrams;
    }

    private RequestBody createPartFromString(String partString) {
        return RequestBody.create(okhttp3.MultipartBody.FORM, partString);
    }
}
