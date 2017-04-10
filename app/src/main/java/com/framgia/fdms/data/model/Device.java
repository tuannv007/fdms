package com.framgia.fdms.data.model;

import java.io.Serializable;

/**
 * Created by Age on 4/1/2017.
 */
public class Device implements Serializable {
    private String mName;
    private String mDate;
    private String mCategory;
    private String mImage;
    private String mDescription;
    private String mStatus;

    public Device(String name, String date, String category, String image) {
        mName = name;
        mDate = date;
        mCategory = category;
        mImage = image;
    }

    public Device(String name, String date, String category, String image, String description,
            String status) {
        mName = name;
        mDate = date;
        mCategory = category;
        mImage = image;
        mDescription = description;
        mStatus = status;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }
}
