package com.framgia.fdms.data.source.api.service;

import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.model.User;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface FDMSApi {
    @GET("/api/v1/search/users")
    Observable<List<Device>> getListDevice(@Query("per_page") int limit,
            @Query("q") String searchTerm);

    @POST("/api/v1/sessions")
    Observable<Respone<User>> login(@Query("user[email]") String userName,
            @Query("user[password]") String passWord);

    @GET("/api/v1/search/devices")
    Observable<List<Device>> searchDevices(@Query("keyWord") String type);

    @GET("/api/v1/devices")
    Observable<Respone<List<Device>>> getListDevices(@QueryMap Map<String, String> parrams);

    @GET("/api/v1/device_categories")
    Observable<Respone<List<Category>>> getListCategory();

    @GET("/api/v1/device_status")
    Observable<Respone<List<Status>>> getListStatus();

    @GET("/api/v1/device_code")
    Observable<Respone<Device>> getDeviceByQrCode(@Query("printed_code") String qrCode);

    @Multipart
    @POST("/api/v1/devices")
    Observable<Respone<Device>> uploadDevice(
            @PartMap Map<String, RequestBody> parrams,
            @Part MultipartBody.Part picture
    );

    @GET("/api/v1/request_dashboard")
    Observable<Respone<List<Dashboard>>> getDashboardRequest();

    @GET("/api/v1/device_dashboard")
    Observable<Respone<List<Dashboard>>> getDeviceDashboard();
}
