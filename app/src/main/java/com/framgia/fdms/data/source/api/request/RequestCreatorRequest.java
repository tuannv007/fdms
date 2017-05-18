package com.framgia.fdms.data.source.api.request;

import java.util.List;

/**
 * Created by MyPC on 18/05/2017.
 */

public class RequestCreatorRequest extends BaseRequest {
    private String mTitle;
    private String mDescription;
    private int mForUserId;
    private int mAssigneeId;
    private List<DeviceRequest> mDeviceRequests;

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

    public int getForUserId() {
        return mForUserId;
    }

    public void setForUserId(int forUserId) {
        mForUserId = forUserId;
    }

    public int getAssigneeId() {
        return mAssigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        mAssigneeId = assigneeId;
    }

    public List<DeviceRequest> getDeviceRequests() {
        return mDeviceRequests;
    }

    public void setDeviceRequests(List<DeviceRequest> deviceRequests) {
        mDeviceRequests = deviceRequests;
    }

    public class DeviceRequest {
        private String mDescription;
        private int mDeviceCategoryId;
        private int mNumber;

        public String getDescription() {
            return mDescription;
        }

        public void setDescription(String description) {
            mDescription = description;
        }

        public int getDeviceCategoryId() {
            return mDeviceCategoryId;
        }

        public void setDeviceCategoryId(int deviceCategoryId) {
            mDeviceCategoryId = deviceCategoryId;
        }

        public int getNumber() {
            return mNumber;
        }

        public void setNumber(int number) {
            mNumber = number;
        }
    }
}
