package com.framgia.fdms.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.fdms.BR;
import com.framgia.fdms.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.framgia.fdms.utils.Constant.AVAIABLE;
import static com.framgia.fdms.utils.Constant.BROKEN;
import static com.framgia.fdms.utils.Constant.USING;

/**
 * Created by Hoang Van Nha on 5/23/2017.
 * <></>
 */

public class DeviceHistoryDetail extends BaseObservable {
    private final String STATUS_USING = "using";
    private final String STATUS_AVAILABLE = "available";
    private final String STATUS_BROKEN = "broken";
    private Date mDate;
    private int mState;
    private String mUserAssigner;

    public DeviceHistoryDetail(String date, String userAssigner, int state) {
        mDate = convertToDate(date);
        mState = state;
        mUserAssigner = userAssigner;
    }

    @Bindable
    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public int getState() {
        return mState;
    }

    public void setState(int state) {
        mState = state;
        notifyPropertyChanged(BR.state);
    }

    @Bindable
    public String getUserAssigner() {
        return mUserAssigner;
    }

    public void setUserAssigner(String userAssigner) {
        mUserAssigner = userAssigner;
        notifyPropertyChanged(BR.userAssigner);
    }

    public String getStatusName() {
        switch (mState) {
            case USING:
                return STATUS_USING;
            case AVAIABLE:
                return STATUS_AVAILABLE;
            case BROKEN:
                return STATUS_BROKEN;
            default:
                return STATUS_USING;
        }
    }

    public int getStatusImage() {
        switch (mState) {
            case USING:
                return R.drawable.ic_using;
            case AVAIABLE:
                return R.drawable.ic_avaiable;
            case BROKEN:
                return R.drawable.ic_broken;
            default:
                return R.drawable.ic_avaiable;
        }
    }

    private Date convertToDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
