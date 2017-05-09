package com.framgia.fdms.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/**
 * Created by beepi on 09/05/2017.
 */

public class Request implements Serializable {
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

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getRequestStatus() {
        return mRequestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        mRequestStatus = requestStatus;
    }

    public String getAssignee() {
        return mAssignee;
    }

    public void setAssignee(String assignee) {
        mAssignee = assignee;
    }

    public String getRequestFor() {
        return mRequestFor;
    }

    public void setRequestFor(String requestFor) {
        mRequestFor = requestFor;
    }

    public String getCreater() {
        return mCreater;
    }

    public void setCreater(String creater) {
        mCreater = creater;
    }

    public String getUpdater() {
        return mUpdater;
    }

    public void setUpdater(String updater) {
        mUpdater = updater;
    }

    public List<DeviceRequest> getDevices() {
        return mDevices;
    }

    public void setDevices(List<DeviceRequest> devices) {
        mDevices = devices;
    }

    public class DeviceRequest implements Serializable {
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
    }
}
