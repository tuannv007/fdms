package com.framgia.fdms.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;
import java.util.Date;

/**
 * Created by Nhahv0902 on 6/1/2017.
 * <></>
 */

public class Notification extends BaseObservable {
    private String mTitle;
    private String mUserRequest;
    private Date mDateTime;

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
        notifyPropertyChanged(BR.title);
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
    public Date getDateTime() {
        return mDateTime;
    }

    public void setDateTime(Date dateTime) {
        mDateTime = dateTime;
        notifyPropertyChanged(BR.dateTime);
    }
}
