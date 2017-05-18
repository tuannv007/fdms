package com.framgia.fdms.data.source.api.request;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;
import android.widget.NumberPicker;
import com.framgia.fdms.BR;
import com.framgia.fdms.screen.requestcreation.RequestCreationViewModel;

/**
 * Created by MyPC on 19/05/2017.
 */

public class DeviceRequest extends BaseObservable{
    private String mDescription;
    private int mDeviceCategoryId;
    private int mNumber;

    public DeviceRequest() {
    }

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

    @Bindable
    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
        notifyPropertyChanged(BR.number);
    }

    public void onDecrement(RequestCreationViewModel viewModel, int position){
        viewModel.onAddRequestDetailClick(position);
        if (getNumber() > 0) {
            setNumber(getNumber() - 1);
        }
    }

    public void onIncrement(RequestCreationViewModel viewModel, int position){
        viewModel.onAddRequestDetailClick(position);
        setNumber(getNumber() + 1);
    }
}
