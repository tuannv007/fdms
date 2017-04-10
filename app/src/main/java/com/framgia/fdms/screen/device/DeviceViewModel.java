package com.framgia.fdms.screen.device;

import android.content.Context;
import android.databinding.BaseObservable;
import android.widget.Toast;
import com.framgia.fdms.R;

/**
 * Exposes the data to be used in the Device screen.
 */

public class DeviceViewModel extends BaseObservable implements DeviceContract.ViewModel {

    private static final String TAG = "DeviceViewModel";

    private Context mContext;
    private DeviceContract.Presenter mPresenter;
    private String mTitleError;
    private String mDescriptionError;
    private String mNameDeviceError;
    private String mCategoryError;
    private String mNumberError;

    public DeviceViewModel(Context context) {
        this.mContext = context;
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
    public void setPresenter(DeviceContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void onCreateDeviceClick() {
        Toast.makeText(mContext, R.string.msg_register_success, Toast.LENGTH_SHORT).show();
    }
}
