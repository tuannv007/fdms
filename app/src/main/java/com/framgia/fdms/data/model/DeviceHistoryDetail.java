package com.framgia.fdms.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.fdms.BR;

/**
 * Created by Hoang Van Nha on 5/23/2017.
 * <></>
 */

public class DeviceHistoryDetail extends BaseObservable {
    private String mDate;
    private String mUserRequest;
    private String mUserAssigner;

    public DeviceHistoryDetail(String date, String userRequest, String userAssigner) {
        mDate = date;
        mUserRequest = userRequest;
        mUserAssigner = userAssigner;
    }

    @Bindable
    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getUserRequest() {
        return mUserRequest;
    }

    public void setUserRequest(String userRequest) {
        mUserRequest = userRequest;
        notifyPropertyChanged(BR.userRequest);
    }

    @Bindable
    public String getUserAssigner() {
        return mUserAssigner;
    }

    public void setUserAssigner(String userAssigner) {
        mUserAssigner = userAssigner;
        notifyPropertyChanged(BR.userAssigner);
    }
}
