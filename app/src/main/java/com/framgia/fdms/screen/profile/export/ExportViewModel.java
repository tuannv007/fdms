package com.framgia.fdms.screen.profile.export;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import static com.framgia.fdms.utils.permission.PermissionUtil.checkWritePermission;

/**
 * Created by tuanbg on 6/14/17.
 */

public class ExportViewModel implements ExportContract.ViewModel {
    private ExportContract.Presenter mPresenter;
    private DialogFragment mFragment;

    public ExportViewModel(DialogFragment fragment) {
        mFragment = fragment;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(ExportContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void exportPdf() {
        if (checkWritePermission((AppCompatActivity) mFragment.getActivity())) {
            mPresenter.exportTask();
            mFragment.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
    }
}
