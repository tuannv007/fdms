package com.framgia.fdms.screen.request.userrequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.Bindable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.Toast;
import com.framgia.fdms.BR;
import com.framgia.fdms.BaseFragmentContract;
import com.framgia.fdms.BaseFragmentModel;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.screen.request.OnMenuClickListenner;
import com.framgia.fdms.screen.requestdetail.RequestDetailActivity;
import com.framgia.fdms.screen.selection.StatusSelectionActivity;
import com.framgia.fdms.screen.selection.StatusSelectionType;
import java.util.ArrayList;
import java.util.List;

import static com.framgia.fdms.utils.Constant.BundleConstant.BUNDLE_STATUE;
import static com.framgia.fdms.utils.Constant.OUT_OF_INDEX;
import static com.framgia.fdms.utils.Constant.RequestConstant.REQUEST_SELECTION;
import static com.framgia.fdms.utils.Constant.RequestConstant.REQUEST_STATUS;

/**
 * Exposes the data to be used in the RequestManager screen.
 */

public class UserRequestViewModel extends BaseFragmentModel
        implements UserRequestContract.ViewModel, OnMenuClickListenner {

    private final Context mContext;
    private final Fragment mFragment;
    private UserRequestAdapter mAdapter;

    private List<Status> mStatuses = new ArrayList<>();
    private List<Status> mRelatives = new ArrayList<>();

    private Status mStatus;
    private FragmentActivity mActivity;
    private Status mRelative;

    public UserRequestViewModel(FragmentActivity activity, Fragment fragment) {
        mContext = activity.getApplicationContext();
        mActivity = activity;
        mFragment = fragment;
        mAdapter = new UserRequestAdapter(mContext, new ArrayList<Request>(), this, this);
        setStatus(new Status(OUT_OF_INDEX, mContext.getString(R.string.title_request_status)));
        setRelative(new Status(OUT_OF_INDEX, mContext.getString(R.string.title_request_relative)));
    }

    @Override
    public void onStart() {
        if (mPresenter == null) return;
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    public void setPresenter(BaseFragmentContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setAdapter(UserRequestAdapter adapter) {
        mAdapter = adapter;
    }

    public UserRequestAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onGetRequestSuccess(List<Request> requests) {
        mAdapter.onUpdatePage(requests);
    }

    @Override
    public void onGetStatusSuccess(List<Status> statuses) {
        updateStatus(statuses);
    }

    @Override
    public void onGetRelativeSuccess(List<Status> relatives) {
        updateRelative(relatives);
    }

    @Override
    public void onLoadError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getData() {
        mPresenter.getData(null, null);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null || data.getExtras() == null || resultCode != Activity.RESULT_OK) {
            return;
        }
        Bundle bundle = data.getExtras();
        Status status = bundle.getParcelable(BUNDLE_STATUE);
        switch (requestCode) {
            case REQUEST_SELECTION:
                if (status != null) {
                    setRelative(status);
                    mAdapter.clear();
                    mPresenter.getData(mRelative, mStatus);
                }
                break;
            case REQUEST_STATUS:
                if (status != null) {
                    setStatus(status);
                    mAdapter.clear();
                    mPresenter.getData(mRelative, mStatus);
                }
                break;
            default:
                break;
        }
    }

    public void onSelectStatusClick() {
        if (mStatuses == null) return;
        mFragment.startActivityForResult(
                StatusSelectionActivity.getInstance(mContext, null, mStatuses,
                        StatusSelectionType.STATUS), REQUEST_STATUS);
    }

    public void onSelectRelativeClick() {
        if (mRelatives == null) return;
        mFragment.startActivityForResult(
                StatusSelectionActivity.getInstance(mContext, null, mRelatives,
                        StatusSelectionType.STATUS), REQUEST_SELECTION);
    }

    public void updateStatus(List<Status> list) {
        if (list == null) {
            return;
        }
        mStatuses = list;
    }

    public void updateRelative(List<Status> relatives) {
        if (relatives == null) {
            return;
        }
        mRelatives = relatives;
    }

    @Bindable
    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
        notifyPropertyChanged(BR.status);
    }

    @Bindable
    public Status getRelative() {
        return mRelative;
    }

    public void setRelative(Status relative) {
        mRelative = relative;
        notifyPropertyChanged(BR.relative);
    }

    @Override
    public void onMenuClick(View v, UserRequestAdapter.RequestModel request) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.getMenuInflater().inflate(R.menu.menu_request, popupMenu.getMenu());
        popupMenu.show();
    }

    public void viewRequestDetail(Request request) {
        mActivity.startActivity(RequestDetailActivity.newInstance(mContext, request));
    }
}
