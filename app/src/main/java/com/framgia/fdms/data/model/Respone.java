package com.framgia.fdms.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by MyPC on 26/04/2017.
 */

public class Respone<T> {
    @Expose
    @SerializedName("status")
    private int mStatus;
    @Expose
    @SerializedName("error")
    private boolean mError;
    @Expose
    @SerializedName("message")
    private String mMessage;
    @Expose
    @SerializedName("data")
    private T mData;
    @Expose
    @SerializedName("token")
    private String mToken;
    @SerializedName("total_request")
    private int mTotalRequest;

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public boolean isError() {
        return mError;
    }

    public void setError(boolean error) {
        mError = error;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

    public int getTotalRequest() {
        return mTotalRequest;
    }

    public void setTotalRequest(int totalRequest) {
        mTotalRequest = totalRequest;
    }
}
