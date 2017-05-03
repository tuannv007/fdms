package com.framgia.fdms.data.source.api.request;

import com.framgia.fdms.data.model.Picture;
import java.io.File;

/**
 * Created by levutantuan on 4/10/17.
 */

public class RegisterDeviceRequest extends BaseRequest {
    private String mProductionName;
    private int mDeviceStatusId;
    private int mDeviceCategoryId;
    private String mSerialNumber;
    private String mModellNumber;
    private String mDeviceCode;
    private String mFilePath;

    public RegisterDeviceRequest() {
    }

    public String getProductionName() {
        return mProductionName;
    }

    public void setProductionName(String productionName) {
        mProductionName = productionName;
    }

    public int getDeviceStatusId() {
        return mDeviceStatusId;
    }

    public void setDeviceStatusId(int deviceStatusId) {
        mDeviceStatusId = deviceStatusId;
    }

    public int getDeviceCategoryId() {
        return mDeviceCategoryId;
    }

    public void setDeviceCategoryId(int deviceCategoryId) {
        mDeviceCategoryId = deviceCategoryId;
    }

    public String getSerialNumber() {
        return mSerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        mSerialNumber = serialNumber;
    }

    public String getModellNumber() {
        return mModellNumber;
    }

    public void setModellNumber(String modellNumber) {
        mModellNumber = modellNumber;
    }

    public String getDeviceCode() {
        return mDeviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        mDeviceCode = deviceCode;
    }

    public String getFilePath() {
        return mFilePath;
    }

    public void setFilePath(String filePath) {
        mFilePath = filePath;
    }
}
