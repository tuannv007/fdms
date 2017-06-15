package com.framgia.fdms.screen.profile.chooseexport;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.data.model.User;
import com.framgia.fdms.screen.device.listdevice.ListDeviceAdapter;
import com.framgia.fdms.screen.profile.export.ExportDialogFragment;
import java.util.ArrayList;
import java.util.List;

import static com.framgia.fdms.utils.Constant.TYPE_DIALOG;

/**
 * Created by tuanbg on 6/15/17.
 */

public class ChooseExportViewModel implements ChooseExportContract.ViewModel {
    private ChooseExportContract.Presenter mPresenter;
    private AppCompatActivity mActivity;
    private ListDeviceAdapter mAdapter;
    private User mUser;
    private List<Device> mDeviceList = new ArrayList<>();

    public ChooseExportViewModel(AppCompatActivity activity, User user) {
        mActivity = activity;
        mAdapter = new ListDeviceAdapter(mActivity, mDeviceList, null);
        mUser = user;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(ChooseExportContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProgressbar() {
        // // TODO: 6/15/17 show Progress bar
    }

    @Override
    public void hideProgressbar() {
        //// TODO: 6/15/17 Hide progress bar
    }

    @Override
    public void onError(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDeviceLoaded(List<Device> devices) {
        mAdapter.clear();
        mDeviceList.addAll(devices);
        mAdapter.onUpdatePage(mDeviceList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mActivity.getMenuInflater().inflate(R.menu.menu_export, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mActivity.onBackPressed();
                break;
            case R.id.item_using:
                // TODO: 6/15/17 getList Using
                return true;
            case R.id.item_used:
                // TODO: 6/15/17 getList Used
                return true;
        }
        return false;
    }

    public ListDeviceAdapter getAdapter() {
        return mAdapter;
    }

    public void initToolbar(Toolbar toolbar) {
        mActivity.setSupportActionBar(toolbar);
        if (mActivity.getSupportActionBar() == null) return;
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void exportData() {
        FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();
        ExportDialogFragment newFragment = ExportDialogFragment.newInstance(mUser);
        newFragment.show(ft, TYPE_DIALOG);
    }
}
