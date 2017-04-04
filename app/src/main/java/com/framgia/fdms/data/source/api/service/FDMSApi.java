package com.framgia.fdms.data.source.api.service;

import com.framgia.fdms.data.model.Device;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface FDMSApi {
    @GET("/search/users")
    Observable<List<Device>> getListDevice(@Query("per_page") int limit,
            @Query("q") String searchTerm);
}
