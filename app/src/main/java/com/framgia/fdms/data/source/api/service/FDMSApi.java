package com.framgia.fdms.data.source.api.service;

import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Respone;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.model.User;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface FDMSApi {
    @GET("/api/v1/search/users")
    Observable<List<Device>> getListDevice(@Query("per_page") int limit,
            @Query("q") String searchTerm);

    @GET("/api/v1/user")
    Call<User> login(@QueryMap Map<String, String> params);

    @GET("/api/v1/search/devices")
    Observable<List<Device>> searchDevices(@Query("keyWord") String type);

    @GET("/api/v1/devices")
    Observable<Respone<List<Device>>> getListDevices(@QueryMap Map<String, String> parrams);

    @GET("/api/v1/device_categories")
    Observable<Respone<List<Category>>> getListCategory();

    @GET("/api/v1/device_status")
    Observable<Respone<List<Status>>> getListStatus();
}
