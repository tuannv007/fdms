package com.framgia.fdms.screen.request;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.fdms.BR;
import com.framgia.fdms.data.model.User;
import com.framgia.fdms.screen.request.requestmanager.RequestManagerFragment;
import com.framgia.fdms.screen.request.userrequest.UserRequestFragment;
import com.framgia.fdms.screen.requestcreation.RequestCreationActivity;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.framgia.fdms.utils.Constant.RequestConstant.REQUEST_CREATE_REQUEST;

/**
 * Exposes the data to be used in the Request screen.
 */

public class RequestViewModel extends BaseObservable implements RequestContract.ViewModel {

    private RequestContract.Presenter mPresenter;
    private RequestPagerAdapter mAdapter;
    private RequestFragment mFragment;
    private Context mContext;
    private boolean mIsBo;

    public RequestViewModel(RequestFragment fragment) {
        mFragment = fragment;
        mContext = fragment.getContext();
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
    public void setPresenter(RequestContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public RequestPagerAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(RequestPagerAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Override
    public void onRegisterRequestClick() {
        mFragment.startActivityForResult(
                RequestCreationActivity.getInstance(mFragment.getActivity()),
                REQUEST_CREATE_REQUEST);
    }

    @Override
    public void onGetCurrentUserSuccess(User user) {
        String role = user.getRole();
        if (role == null) return;

        setBo(user.isBo());

        List<BaseRequestFragment> fragments = new ArrayList<>();
        fragments.add(UserRequestFragment.newInstance());
        if (mIsBo) fragments.add(RequestManagerFragment.newInstance());
        mAdapter =
                new RequestPagerAdapter(mContext, mFragment.getChildFragmentManager(), fragments);
        setAdapter(mAdapter);
    }

    @Override
    public void onError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) return;
        if (requestCode == REQUEST_CREATE_REQUEST) {
            mAdapter.refreshData();
        }
    }

    @Bindable
    public boolean isBo() {
        return mIsBo;
    }

    public void setBo(boolean bo) {
        mIsBo = bo;
        notifyPropertyChanged(BR.bo);
    }
}
