package com.framgia.fdms.screen.device;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.framgia.fdms.BR;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.source.api.request.RegisterDeviceRequest;
import com.framgia.fdms.screen.main.MainActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Device screen.
 */

public class DeviceViewModel extends BaseObservable implements DeviceContract.ViewModel {

    private Context mContext;
    private DeviceContract.Presenter mPresenter;
    private String mTitleError;
    private String mDescriptionError;
    private String mNameDeviceError;
    private String mCategoryError;
    private String mNumberError;
    private RegisterDeviceRequest mRequest;
    private ArrayAdapter<String> mAdapter;
    private List<String> mCategories = new ArrayList<>();

    public DeviceViewModel(Context context) {
        this.mContext = context;
        mAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, mCategories);
        mRequest = new RegisterDeviceRequest();
    }

    @Bindable
    public ArrayAdapter<String> getAdapter() {
        return mAdapter;
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
        if (!mPresenter.validateDataInput(mRequest)) {
            return;
        }
        Toast.makeText(mContext, R.string.msg_register_success, Toast.LENGTH_SHORT).show();
        mPresenter.registerDevice(mRequest);
    }

    @Override
    public void onDCategoryLoaded(List<Category> categories) {
        updateData(categories);
    }

    public void updateData(List<Category> list) {
        if (list == null) {
            return;
        }
        mCategories.clear();
        for (Category category : list) {
            mAdapter.addAll(category.getTitle());
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressbar() {

        //TODO showProgressbar
    }

    @Override
    public void hideProgressbar() {
        //TODO hideProgressbar
    }

    @Override
    public void onRegisterError() {
        Toast.makeText(mContext, R.string.msg_create_account_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess() {
        mContext.startActivity(new Intent(mContext, MainActivity.class));
    }

    @Override
    public void onInputTitleError() {
        mTitleError = mContext.getString(R.string.msg_error_user_name);
        notifyPropertyChanged(BR.titleError);
    }

    @Override
    public void onInputDescriptionError() {
        mDescriptionError = mContext.getString(R.string.msg_error_user_name);
        notifyPropertyChanged(BR.descriptionError);
    }

    @Override
    public void onInputDeviceNameError() {
        mNameDeviceError = mContext.getString(R.string.msg_error_user_name);
        notifyPropertyChanged(BR.nameDeviceError);
    }

    @Override
    public void onInputCategoryError() {
        mCategoryError = mContext.getString(R.string.msg_error_user_name);
        notifyPropertyChanged(BR.categoryError);
    }

    @Override
    public void onInputNumberError() {
        mNumberError = mContext.getString(R.string.msg_error_user_name);
        notifyPropertyChanged(BR.numberError);
    }

    @Bindable
    public String getTitle() {
        return mRequest.getTitle();
    }

    public void setTitle(String title) {
        mRequest.setTitle(title);
    }

    @Bindable
    public String getDescription() {
        return mRequest.getDescription();
    }

    public void setDescription(String description) {
        mRequest.setDescription(description);
    }

    @Bindable
    public String getNameDevice() {
        return mRequest.getDeviceName();
    }

    public void setNameDevice(String nameDevice) {
        mRequest.setDeviceName(nameDevice);
    }

    @Bindable
    public String getCategory() {
        return mRequest.getCategory();
    }

    public void setCategory(String category) {
        mRequest.setCategory(category);
    }

    @Bindable
    public String getNumber() {
        return mRequest.getNumber();
    }

    public void setNumber(String number) {
        mRequest.setNumber(number);
    }

    @Bindable
    public String getTitleError() {
        return mTitleError;
    }

    @Bindable
    public String getDescriptionError() {
        return mDescriptionError;
    }

    @Bindable
    public String getNameDeviceError() {
        return mNameDeviceError;
    }

    @Bindable
    public String getCategoryError() {
        return mCategoryError;
    }

    @Bindable
    public String getNumberError() {
        return mNumberError;
    }
}
