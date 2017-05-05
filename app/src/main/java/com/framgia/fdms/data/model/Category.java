package com.framgia.fdms.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by levutantuan on 4/10/17.
 */

public class Category {
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("name")
    private String mName;

    public Category(int id, String name) {
        mId = id;
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return  + mId + ". " + mName;
    }
}