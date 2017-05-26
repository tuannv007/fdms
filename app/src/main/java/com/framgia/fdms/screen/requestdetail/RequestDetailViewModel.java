package com.framgia.fdms.screen.requestdetail;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.source.CategoryRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.CategoryRemoteDataSource;
import java.util.List;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tuanbg on 5/24/17.
 */

public class RequestDetailViewModel
        implements RequestDetailContract.ViewModel {
    private Context mContext;
    private FragmentActivity mActivity;
    private ObservableBoolean mIsEdit = new ObservableBoolean();
    private RequestDetailAdapter mAdapter;
    private ArrayAdapter<Category> mAdapterCategory;
    private CategoryRepository mCategoryRepository;
    private CompositeSubscription mSubscription;

    public RequestDetailViewModel(AppCompatActivity activity, List<Request.DeviceRequest> request) {
        mContext = activity;
        mActivity = activity;
        mIsEdit.set(false);
        mAdapter = new RequestDetailAdapter(activity, this);
        mSubscription = new CompositeSubscription();
        mAdapter.onUpdatePage(request);
        mAdapterCategory =
                new ArrayAdapter<>(mActivity, R.layout.support_simple_spinner_dropdown_item);
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

    public ObservableBoolean getIsEdit() {
        return mIsEdit;
    }

    public RequestDetailAdapter getAdapter() {
        return mAdapter;
    }

    public ArrayAdapter<Category> getAdapterCategory() {
        return mAdapterCategory;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        // TODO: 5/26/17 set presenter in request detail
    }
}
