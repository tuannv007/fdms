package com.framgia.fdms.screen.profile.export;

import android.support.v4.app.DialogFragment;

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
        mPresenter.exportTask();
        mFragment.dismiss();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
    }
}
