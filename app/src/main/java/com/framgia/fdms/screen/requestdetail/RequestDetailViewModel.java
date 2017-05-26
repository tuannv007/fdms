package com.framgia.fdms.screen.requestdetail;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Request;
import java.util.List;

/**
 * Created by tuanbg on 5/24/17.
 */

public class RequestDetailViewModel implements RequestDetailContract.ViewModel {
    private Context mContext;
    private FragmentActivity mActivity;
    private ObservableBoolean mIsEdit = new ObservableBoolean();
    private RequestDetailAdapter mAdapter;
    private ArrayAdapter<Category> mAdapterCategory;
    private RequestDetailContract.Presenter mPresenter;

    public RequestDetailViewModel(AppCompatActivity activity, List<Request.DeviceRequest> request) {
        mContext = activity;
        mActivity = activity;
        mIsEdit.set(false);
        mAdapter = new RequestDetailAdapter(activity, this, request);
        mAdapterCategory =
                new ArrayAdapter<>(mActivity, R.layout.support_simple_spinner_dropdown_item);
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
        // TODO: 5/26/17 show progressbar
    }

    @Override
    public void hideProgressbar() {
        // TODO: 5/26/17 hide progressbar
    }

    public void onAddRequestDetailClick(int position) {
        if (position == (mAdapter.getItemCount() - 1)) {
            mAdapter.addItem();
        }
    }

    @Override
    public void onLoadError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetCategorySuccess(List<Category> categories) {
        if (categories == null) {
            return;
        }
        mAdapterCategory.clear();
        mAdapterCategory.addAll(categories);
        mAdapterCategory.notifyDataSetChanged();
    }

    @Override
    public void editRequestSuccess(Request request) {
        Log.e("tagg", request.getDevices().toString());
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
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(RequestDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void editRequest() {
        mPresenter.editRequest();
    }
}
