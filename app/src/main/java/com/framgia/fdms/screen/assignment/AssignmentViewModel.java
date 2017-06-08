package com.framgia.fdms.screen.assignment;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.framgia.fdms.BR;
import com.framgia.fdms.data.model.Request;

/**
 * Exposes the data to be used in the Assignment screen.
 */

public class AssignmentViewModel extends BaseObservable implements AssignmentContract.ViewModel {

    private AssignmentContract.Presenter mPresenter;
    private AppCompatActivity mActivity;
    private int mProgressBarVisibility = View.GONE;
    private Request mRequest;
    private AssignmentAdapter mAdapter;

    public AssignmentViewModel(AppCompatActivity activity) {
        mActivity = activity;
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
    public void setPresenter(AssignmentContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onAddItemClick() {

    }

    @Override
    public void onAssignClick() {

    }

    public AppCompatActivity getActivity() {
        return mActivity;
    }

    @Bindable
    public int getProgressBarVisibility() {
        return mProgressBarVisibility;
    }

    public void setProgressBarVisibility(int progressBarVisibility) {
        mProgressBarVisibility = progressBarVisibility;
        notifyPropertyChanged(BR.progressBarVisibility);
    }

    @Bindable
    public Request getRequest() {
        return mRequest;
    }

    public void setRequest(Request request) {
        mRequest = request;
        notifyPropertyChanged(BR.request);
    }

    @Bindable
    public AssignmentAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(AssignmentAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }
}
