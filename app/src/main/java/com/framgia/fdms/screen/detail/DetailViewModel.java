package com.framgia.fdms.screen.detail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.fdms.data.model.Device;

/**
 * Exposes the data to be used in the Detail screen.
 */

public class DetailViewModel extends BaseObservable implements DetailContract.ViewModel {

    private Context mContext;
    private DetailContract.Presenter mPresenter;
    private Device mDevice;

    public DetailViewModel(Context context, Device device) {
        mContext = context;
        mDevice = device;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public String getName() {
        return mDevice.getName();
    }

    @Bindable
    public String getCategory() {
        return mDevice.getCategory();
    }

    @Bindable
    public String getDescription() {
        return mDevice.getDescription();
    }

    @Bindable
    public String getImageUrl() {
        return mDevice.getImage();
    }
}
