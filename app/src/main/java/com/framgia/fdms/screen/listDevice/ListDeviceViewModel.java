package com.framgia.fdms.screen.listDevice;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.android.databinding.library.baseAdapters.BR;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.Status;
import com.framgia.fdms.screen.devicecreation.CreateDeviceActivity;
import com.framgia.fdms.screen.devicedetail.DeviceDetailActivity;
import com.framgia.fdms.screen.returndevice.ReturnDeviceActivity;
import java.util.ArrayList;
import java.util.List;

import static com.framgia.fdms.utils.Constant.OUT_OF_INDEX;

/**
 * Exposes the data to be used in the ListDevice screen.
 */

public class ListDeviceViewModel extends BaseObservable implements ListDeviceContract.ViewModel {
    private ObservableField<Integer> mProgressBarVisibility = new ObservableField<>();
    private ObservableBoolean mIsLoadingMore = new ObservableBoolean(false);
    private ListDeviceAdapter mAdapter;
    private ListDeviceContract.Presenter mPresenter;
    private Context mContext;
    private FragmentActivity mActivity;
    private ArrayAdapter<Category> mAdapterCategory;
    private ArrayAdapter<Status> mAdapterStatus;
    private Category mCategory;
    private Status mStatus;
    private String mKeyWord;

    public ObservableBoolean getIsLoadingMore() {
        return mIsLoadingMore;
    }

    public ListDeviceViewModel(FragmentActivity activity) {
        mActivity = activity;
        mContext = activity.getApplicationContext();
        mAdapter = new ListDeviceAdapter(mContext, new ArrayList<Device>(), this);

        mAdapterCategory = new ArrayAdapter<Category>(mContext, R.layout.select_dialog_item);
        mAdapterStatus = new ArrayAdapter<Status>(mContext, R.layout.select_dialog_item);
        setCategory(new Category(OUT_OF_INDEX, mContext.getString(R.string.title_btn_category)));
        setStatus(new Status(OUT_OF_INDEX, mContext.getString(R.string.title_request_status)));
    }

    @Override
    public void onChooseCategory() {
        if (mAdapterCategory == null) {
            return;
        }

        AlertDialog.Builder builder =
                new AlertDialog.Builder(mActivity).setTitle(R.string.title_category)
                        .setNegativeButton(R.string.action_cancel, null)
                        .setPositiveButton(R.string.action_clear,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        setCategory(new Category(OUT_OF_INDEX,
                                                mContext.getString(R.string.title_btn_category)));
                                        mAdapter.clear();
                                        mPresenter.getData(mKeyWord, mCategory, mStatus);
                                    }
                                })
                        .setAdapter(mAdapterCategory, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setCategory(mAdapterCategory.getItem(which));
                                mAdapter.clear();
                                mPresenter.getData(mKeyWord, mCategory, mStatus);
                            }
                        });
        builder.show();
    }

    @Override
    public void onChooseStatus() {
        if (mAdapterStatus == null) {
            return;
        }
        AlertDialog.Builder builder =
                new AlertDialog.Builder(mActivity).setTitle(R.string.title_status_device)
                        .setNegativeButton(R.string.action_cancel, null)
                        .setPositiveButton(R.string.action_clear,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        setStatus(new Status(OUT_OF_INDEX,
                                                mContext.getString(R.string.title_request_status)));
                                        mAdapter.clear();
                                        mPresenter.getData(mKeyWord, mCategory, mStatus);
                                    }
                                })
                        .setAdapter(mAdapterStatus, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setStatus(mAdapterStatus.getItem(which));
                                mAdapter.clear();
                                mPresenter.getData(mKeyWord, mCategory, mStatus);
                            }
                        });
        builder.show();
    }

    @Override
    public void onReset() {
        mAdapter.clear();
        mPresenter.getData(null, mCategory, mStatus);
    }

    @Override
    public void getData() {
        mPresenter.getData(null, null, null);
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
    public void setPresenter(ListDeviceContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDeviceLoaded(List<Device> devices) {
        mIsLoadingMore.set(false);
        mAdapter.onUpdatePage(devices);
    }

    @Override
    public void onDeviceClick(Device device) {
        mContext.startActivity(DeviceDetailActivity.getInstance(mContext, device.getId()));
    }

    @Override
    public void showProgressbar() {
        mProgressBarVisibility.set(View.VISIBLE);
    }

    @Override
    public void onError(String msg) {
        mIsLoadingMore.set(false);
        hideProgressbar();
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgressbar() {
        mProgressBarVisibility.set(View.GONE);
    }

    @Override
    public void onRegisterDeviceClick() {
        mContext.startActivity(ReturnDeviceActivity.newIntent(mContext));
    }

    @Override
    public void onStartReturnDevice() {
        mContext.startActivity(CreateDeviceActivity.getInstance(mContext));
    }

    @Override
    public void onDeviceCategoryLoaded(List<Category> categories) {
        updateCategory(categories);
    }

    @Override
    public void onDeviceStatusLoaded(List<Status> statuses) {
        updateStatus(statuses);
    }

    @Override
    public void onSearch(String keyWord) {
        mAdapter.clear();
        mKeyWord = keyWord;
        mPresenter.getData(mKeyWord, mCategory, mStatus);
    }

    public void updateCategory(List<Category> list) {
        if (list == null) {
            return;
        }
        mAdapterCategory.clear();
        mAdapterCategory.addAll(list);
        mAdapterCategory.notifyDataSetChanged();
    }

    public void updateStatus(List<Status> list) {
        if (list == null) {
            return;
        }
        mAdapterStatus.clear();
        mAdapterStatus.addAll(list);
        mAdapterStatus.notifyDataSetChanged();
    }

    public ObservableField<Integer> getProgressBarVisibility() {
        return mProgressBarVisibility;
    }

    private RecyclerView.OnScrollListener mScrollListenner = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy <= 0) {
                return;
            }

            LinearLayoutManager layoutManager =
                    (LinearLayoutManager) recyclerView.getLayoutManager();

            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();

            if (!mIsLoadingMore.get() && (visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                mIsLoadingMore.set(true);
                mPresenter.loadMoreData();
            }
        }
    };

    public RecyclerView.OnScrollListener getScrollListenner() {
        return mScrollListenner;
    }

    @Bindable
    public ListDeviceAdapter getAdapter() {
        return mAdapter;
    }

    @Bindable
    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
        notifyPropertyChanged(BR.category);
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
