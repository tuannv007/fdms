package com.framgia.fdms.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Age on 4/1/2017.
 */
public class Device implements Serializable {
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("device_code")
    private String mDeviceCode;
    @Expose
    @SerializedName("production_name")
    private String mProductionName;
    @Expose
    @SerializedName("device_status_id")
    private int mDeviceStatusId;
    @Expose
    @SerializedName("device_category_id")
    private int mDeviceCategoryId;
    @Expose
    @SerializedName("picture")
    private Picture mPicture;
    @Expose
    @SerializedName("original_price")
    private double mOriginalPrice;
    @Expose
    @SerializedName("bought_date")
    private Date mBoughtDate;
    @Expose
    @SerializedName("printed_code")
    private String mPrintedCode;
    @Expose
    @SerializedName("is_barcode")
    private boolean mIsBarcode;
    @Expose
    @SerializedName("device_status_name")
    private String mDeviceStatusName;
    @Expose
    @SerializedName("device_category_name")
    private String mDeviceCategoryName;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getDeviceCode() {
        return mDeviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        mDeviceCode = deviceCode;
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

    public Picture getPicture() {
        return mPicture;
    }

    public void setPicture(Picture picture) {
        mPicture = picture;
    }

    public double getOriginalPrice() {
        return mOriginalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        mOriginalPrice = originalPrice;
    }

    public Date getBoughtDate() {
        return mBoughtDate;
    }

    public void setBoughtDate(Date boughtDate) {
        mBoughtDate = boughtDate;
    }

    public String getPrintedCode() {
        return mPrintedCode;
    }

    public void setPrintedCode(String printedCode) {
        mPrintedCode = printedCode;
    }

    public boolean isBarcode() {
        return mIsBarcode;
    }

    public void setBarcode(boolean barcode) {
        mIsBarcode = barcode;
    }

    public String getDeviceStatusName() {
        return mDeviceStatusName;
    }

    public void setDeviceStatusName(String deviceStatusName) {
        mDeviceStatusName = deviceStatusName;
    }

    public String getDeviceCategoryName() {
        return mDeviceCategoryName;
    }

    public void setDeviceCategoryName(String deviceCategoryName) {
        mDeviceCategoryName = deviceCategoryName;
    }
}
