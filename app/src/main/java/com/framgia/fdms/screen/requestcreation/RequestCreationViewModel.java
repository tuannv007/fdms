package com.framgia.fdms.screen.requestcreation;

import android.content.DialogInterface;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import com.framgia.fdms.BR;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.data.source.api.request.RequestCreatorRequest;
import java.util.List;

/**
 * Exposes the data to be used in the Requestcreation screen.
 */

public class RequestCreationViewModel extends BaseObservable
        implements RequestCreationContract.ViewModel {

    private RequestCreationContract.Presenter mPresenter;
    private AppCompatActivity mActivity;
    private String mRequestTitle;
    private String mRequestDescription;
    private Status mAssignee;
    private Status mRelative;
    private RequestCreatorRequest mRequestCreatorRequest;
    private ArrayAdapter<Status> mAdapterAssignee;
    private ArrayAdapter<Status> mAdapterRelative;

    public RequestCreationViewModel(AppCompatActivity activity) {
        mActivity = activity;
        mRequestCreatorRequest = new RequestCreatorRequest();
        mAdapterAssignee = new ArrayAdapter<Status>(mActivity, R.layout.select_dialog_item);
        mAdapterRelative = new ArrayAdapter<Status>(mActivity, R.layout.select_dialog_item);
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
    public void setPresenter(RequestCreationContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public AppCompatActivity getActivity() {
        return mActivity;
    }

    @Override
    public void onRelativeClick() {
        if (mAdapterRelative == null) {
            return;
        }

        AlertDialog.Builder builder =
                new AlertDialog.Builder(mActivity).setTitle(R.string.title_request_for)
                        .setNegativeButton(R.string.action_cancel, null)
                        .setAdapter(mAdapterRelative, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setRelative(mAdapterRelative.getItem(which));
                            }
                        });
        builder.show();
    }

    @Override
    public void onAssigneeClick() {
        if (mAdapterAssignee == null) {
            return;
        }

        AlertDialog.Builder builder =
                new AlertDialog.Builder(mActivity).setTitle(R.string.title_assign_to)
                        .setNegativeButton(R.string.action_cancel, null)
                        .setAdapter(mAdapterAssignee, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setAssignee(mAdapterAssignee.getItem(which));
                            }
                        });
        builder.show();
    }

    @Override
    public void onCreateRequestClick() {
        // TODO: later
    }

    @Override
    public void onGetAssignedSuccess(List<Status> assignees) {
        updateAssignee(assignees);
    }

    private void updateAssignee(List<Status> assignees) {
        if (assignees == null) {
            return;
        }
        mAdapterAssignee.clear();
        mAdapterAssignee.addAll(assignees);
        mAdapterAssignee.notifyDataSetChanged();
    }

    @Override
    public void onGetRelativeSuccess(List<Status> relatives) {
        updateRelative(relatives);
    }

    private void updateRelative(List<Status> relatives) {
        if (relatives == null) {
            return;
        }
        mAdapterRelative.clear();
        mAdapterRelative.addAll(relatives);
        mAdapterRelative.notifyDataSetChanged();
    }

    @Bindable
    public String getRequestTitle() {
        return mRequestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        mRequestCreatorRequest.setTitle(requestTitle);
        mRequestTitle = requestTitle;
    }

    @Bindable
    public String getRequestDescription() {
        return mRequestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        mRequestCreatorRequest.setDescription(requestDescription);
        mRequestDescription = requestDescription;
    }

    @Bindable
    public Status getAssignee() {
        return mAssignee;
    }

    public void setAssignee(Status assignee) {
        mRequestCreatorRequest.setAssigneeId(assignee.getId());
        mAssignee = assignee;
        notifyPropertyChanged(BR.assignee);
    }

    @Bindable
    public Status getRelative() {
        return mRelative;
    }

    public void setRelative(Status relative) {
        mRequestCreatorRequest.setForUserId(relative.getId());
        mRelative = relative;
        notifyPropertyChanged(BR.relative);
    }
}
