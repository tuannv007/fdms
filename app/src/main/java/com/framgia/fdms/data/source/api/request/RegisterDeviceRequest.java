package com.framgia.fdms.data.source.api.request;

/**
 * Created by levutantuan on 4/10/17.
 */

public class RegisterDeviceRequest extends BaseRequest {
    private String mTitle;
    private String mDescription;
    private String mDeviceName;
    private String mCategory;
    private String mNumber;

    public RegisterDeviceRequest(String title, String description, String deviceName,
            String category, String number) {
        mTitle = title;
        mDescription = description;
        mDeviceName = deviceName;
        mCategory = category;
        mNumber = number;
    }

    public RegisterDeviceRequest() {
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

    public String getDeviceName() {
        return mDeviceName;
    }

    public void setDeviceName(String deviceName) {
        mDeviceName = deviceName;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }
}
