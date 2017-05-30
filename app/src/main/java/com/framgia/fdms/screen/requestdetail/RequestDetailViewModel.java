package com.framgia.fdms.screen.requestdetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.android.databinding.library.baseAdapters.BR;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.source.CategoryRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.CategoryRemoteDataSource;
import com.framgia.fdms.screen.selection.StatusSelectionActivity;
import com.framgia.fdms.screen.selection.StatusSelectionType;
import java.util.ArrayList;
import java.util.List;
import rx.subscriptions.CompositeSubscription;

import static android.app.Activity.RESULT_OK;
import static com.framgia.fdms.utils.Constant.BundleConstant.BUNDLE_CATEGORY;
import static com.framgia.fdms.utils.Constant.RequestConstant.REQUEST_CATEGORY;

/**
 * Created by tuanbg on 5/24/17.
 */

public class RequestDetailViewModel extends BaseObservable
        implements RequestDetailContract.ViewModel {
    private Context mContext;
    private FragmentActivity mActivity;
    private ObservableBoolean mIsEdit = new ObservableBoolean();
    private RequestDetailAdapter mAdapter;
    private CategoryRepository mCategoryRepository;
    private CompositeSubscription mSubscription;
    private List<Category> mCategories = new ArrayList<>();
    private RequestDetailContract.Presenter mPresenter;
    private ObservableField<Category> mCategory = new ObservableField<>();

    public RequestDetailViewModel(AppCompatActivity activity, List<Request.DeviceRequest> request) {
        mContext = activity;
        mActivity = activity;
        mIsEdit.set(false);
        mAdapter = new RequestDetailAdapter(activity, this);
        mAdapter.onUpdatePage(request);
        mSubscription = new CompositeSubscription();
        mCategoryRepository = new CategoryRepository(
                new CategoryRemoteDataSource(FDMSServiceClient.getInstance()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mActivity.getMenuInflater().inflate(R.menu.menu_request_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_edit:
                mIsEdit.set(true);
                break;
        }
        return true;
    }

    @Override
    public void showProgressbar() {
        // TODO: 5/30/17 show progress bar
    }

    @Override
    public void hideProgressbar() {
        // TODO: 5/30/17 hide progress bar
    }

    @Override
    public void onLoadError(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGetCategorySuccess(List<Category> categories) {
        if (categories == null) {
            return;
        }
        mCategories.clear();
        mCategories.addAll(categories);
    }

    public ObservableBoolean getIsEdit() {
        return mIsEdit;
    }

    public RequestDetailAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setPresenter(RequestDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void removeAt(int pos) {
        mAdapter.removeAt(pos);
    }

    public void addAtItem() {
        mAdapter.addItem();
    }

    public void onCategoryClick() {
        if (mCategories == null) return;
        mActivity.startActivityForResult(
                StatusSelectionActivity.getInstance(mContext, mCategories, null,
                        StatusSelectionType.CATEGORY), REQUEST_CATEGORY);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK || data == null) return;
        switch (requestCode) {
            case REQUEST_CATEGORY:
                Bundle bundle = data.getExtras();
                Category category = bundle.getParcelable(BUNDLE_CATEGORY);
                setCategory(category);
                break;
            default:
                break;
        }
    }

    public ObservableField<Category> getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory.set(category);
        notifyPropertyChanged(BR.category);
    }
}
