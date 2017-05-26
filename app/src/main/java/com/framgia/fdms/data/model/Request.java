package com.framgia.fdms.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;
import com.framgia.fdms.FDMSApplication;
import com.framgia.fdms.R;
import com.framgia.fdms.screen.requestdetail.RequestDetailViewModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.framgia.fdms.utils.Constant.DeviceStatus.APPROVED;
import static com.framgia.fdms.utils.Constant.DeviceStatus.CANCELLED;
import static com.framgia.fdms.utils.Constant.DeviceStatus.DONE;
import static com.framgia.fdms.utils.Constant.DeviceStatus.WAITING_APPROVE;
import static com.framgia.fdms.utils.Constant.DeviceStatus.WAITING_DONE;

/**
 * Created by beepi on 09/05/2017.
 */

public class Request extends BaseObservable implements Serializable {
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("title")
    private String mTitle;
    @Expose
    @SerializedName("description")
    private String mDescription;
    @Expose
    @SerializedName("request_status")
    private String mRequestStatus;
    @Expose
    @SerializedName("assignee")
    private String mAssignee;
    @Expose
    @SerializedName("request_for")
    private String mRequestFor;
    @Expose
    @SerializedName("creater")
    private String mCreater;
    @Expose
    @SerializedName("updater")
    private String mUpdater;
    @Expose
    @SerializedName("devices")
    private List<DeviceRequest> mDevices;
    @Expose
    @SerializedName("created_at")
    private Date mCreatedAt;

    private int idStatus;

    public int getIdStatus() {
        if (getRequestStatus().equalsIgnoreCase(CANCELLED)) setIdStatus(1);
        if (getRequestStatus().equalsIgnoreCase(WAITING_APPROVE)) setIdStatus(2);
        if (getRequestStatus().equalsIgnoreCase(APPROVED)) setIdStatus(3);
        if (getRequestStatus().equalsIgnoreCase(WAITING_DONE)) setIdStatus(4);
        if (getRequestStatus().equalsIgnoreCase(DONE)) setIdStatus(5);
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    @Bindable
    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
        notifyPropertyChanged(BR.createdAt);
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
        notifyPropertyChanged(BR.title);
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    @Bindable
    public String getRequestStatus() {
        return mRequestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        mRequestStatus = requestStatus;
        notifyPropertyChanged(BR.requestStatus);
    }

    public String getAssignee() {
        return mAssignee;
    }

    public void setAssignee(String assignee) {
        mAssignee = assignee;
    }

    @Bindable
    public String getRequestFor() {
        return mRequestFor;
    }

    public void setRequestFor(String requestFor) {
        mRequestFor = requestFor;
        notifyPropertyChanged(BR.requestFor);
    }

    @Bindable
    public String getCreater() {
        return mCreater;
    }

    public void setCreater(String creater) {
        mCreater = creater;
    }

    @Bindable
    public String getUpdater() {
        return mUpdater;
    }

    public void setUpdater(String updater) {
        mUpdater = updater;
        notifyPropertyChanged(BR.updater);
    }

    @Bindable
    public List<DeviceRequest> getDevices() {
        return mDevices;
    }

    public void setDevices(List<DeviceRequest> devices) {
        mDevices = devices;
        notifyPropertyChanged(BR.devices);
    }

    @Bindable
    public String getRequestDescription() {
        String nameDevice;
        if (getDevices() == null || getDevices().size() == 0) {
            nameDevice = FDMSApplication.getInstant().getString(R.string.title_device);
        } else {
            nameDevice = getDevices().get(0).getCategoryName();
        }
        return String.format(FDMSApplication.getInstant().getString(R.string.title_request),
                getCreater(), nameDevice, getRequestFor());
    }

    public static class DeviceRequest extends BaseObservable implements Serializable {
        @Expose
        @SerializedName("id")
        private int mId;
        @Expose
        @SerializedName("description")
        private String mDescription;
        @Expose
        @SerializedName("number")
        private int mNumber;
        @Expose
        @SerializedName("category_name")
        private String mCategoryName;

        public int getId() {
            return mId;
        }

        public void setId(int id) {
            mId = id;
        }

        @Bindable
        public String getDescription() {
            return mDescription;
        }

        public void setDescription(String description) {
            mDescription = description;
            notifyPropertyChanged(BR.descriptionError);
        }

        @Bindable
        public int getNumber() {
            return mNumber;
        }

        public void setNumber(int number) {
            mNumber = number;
            notifyPropertyChanged(BR.number);
        }

        @Bindable
        public String getCategoryName() {
            return mCategoryName;
        }

        public void setCategoryName(String categoryName) {
            mCategoryName = categoryName;
            notifyPropertyChanged(BR.categoryName);
        }

        public void onDecrement(RequestDetailViewModel viewModel, int position) {
            viewModel.onAddRequestDetailClick(position);
            if (getNumber() > 0) {
                setNumber(getNumber() - 1);
            }
        }

        public void onIncrement(RequestDetailViewModel viewModel, int position) {
            viewModel.onAddRequestDetailClick(position);
            setNumber(getNumber() + 1);
        }

        @Override
        public String toString() {
            return "DeviceRequest{"
                    + "mId="
                    + mId
                    + ", mDescription='"
                    + mDescription
                    + '\''
                    + ", mNumber="
                    + mNumber
                    + ", mCategoryName='"
                    + mCategoryName
                    + '\''
                    + '}';
        }
    }

    @Override
    public String toString() {
        return "Request{"
                + "mId="
                + mId
                + ", mTitle='"
                + mTitle
                + '\''
                + ", mDescription='"
                + mDescription
                + '\''
                + ", mRequestStatus='"
                + mRequestStatus
                + '\''
                + ", mAssignee='"
                + mAssignee
                + '\''
                + ", mRequestFor='"
                + mRequestFor
                + '\''
                + ", mCreater='"
                + mCreater
                + '\''
                + ", mUpdater='"
                + mUpdater
                + '\''
                + ", mDevices="
                + mDevices
                + ", mCreatedAt="
                + mCreatedAt
                + '}';
    }
}
