package com.framgia.fdms.screen.requestmanager;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import com.android.databinding.library.baseAdapters.BR;
import com.framgia.fdms.BaseFragmentContract;
import com.framgia.fdms.BaseFragmentModel;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.model.Status;
import java.util.ArrayList;
import java.util.List;

import static com.framgia.fdms.utils.Constant.OUT_OF_INDEX;

/**
 * Exposes the data to be used in the RequestManager screen.
 */

public class RequestManagerViewModel extends BaseFragmentModel<Request>
        implements RequestManagerContract.ViewModel {

    private final Context mContext;
    private BaseFragmentContract.Presenter mPresenter;
    private RequestManagerAdapter mAdapter;
    private ObservableField<Boolean> mIsLoadingMore = new ObservableField<>(false);
    private ArrayAdapter<Status> mAdapterStatus;
    private Status mStatus;
    private FragmentActivity mActivity;
    private Status mRelative;
    private String mKeyWord;

    public RequestManagerViewModel(FragmentActivity activity) {
        mContext = activity.getApplicationContext();
        mActivity = activity;
        mAdapter = new RequestManagerAdapter(mContext, new ArrayList<Request>());
        mAdapterStatus = new ArrayAdapter<>(mContext, R.layout.select_dialog_item);
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

    public void setAdapter(RequestManagerAdapter adapter) {
        mAdapter = adapter;
    }

    public RequestManagerAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onErrorLoadPage(String msg) {
        super.onErrorLoadPage(msg);
        Snackbar.make(getActivity().findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG)
                .show();
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
    public void getData() {
        mPresenter.getData(null, null, null);
    }

    public void onChooseStatus() {
        if (mAdapterStatus == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity).setTitle(
                mContext.getString(R.string.title_btn_status))
                .setNegativeButton(mContext.getString(R.string.action_cancel), null)
                .setPositiveButton(mContext.getString(R.string.action_clear),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                setStatus(new Status(OUT_OF_INDEX,
                                        mContext.getString(R.string.title_btn_status)));
                                mPresenter.getData(mKeyWord, mRelative, mStatus);
                            }
                        })
                .setAdapter(mAdapterStatus, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setStatus(mAdapterStatus.getItem(which));
                        mAdapter.clear();
                        mPresenter.getData(mKeyWord, mRelative, mStatus);
                    }
                });
        builder.show();
    }

    public void updateStatus(List<Status> list) {
        if (list == null) {
            return;
        }
        mAdapterStatus.clear();
        mAdapterStatus.addAll(list);
        mAdapterStatus.notifyDataSetChanged();
    }

    @Bindable
    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
        notifyPropertyChanged(BR.status);
    }
}
