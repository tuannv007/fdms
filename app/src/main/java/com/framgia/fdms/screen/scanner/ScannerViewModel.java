package com.framgia.fdms.screen.scanner;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.framgia.fdms.R;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Exposes the data to be used in the Scanner screen.
 */

public class ScannerViewModel implements ScannerContract.ViewModel, ZXingScannerView.ResultHandler {

    private final ScannerActivity mActivity;
    private ScannerContract.Presenter mPresenter;
    private ZXingScannerView mScannerView;

    public ScannerViewModel(ScannerActivity activity) {
        mActivity = activity;
    }

    @Override
    public void init(FrameLayout frameScanner) {
        mScannerView = new ZXingScannerView(mActivity);
        frameScanner.addView(mScannerView);
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onResume() {
        if (mScannerView != null) {
            mScannerView.setResultHandler(this);
            mScannerView.startCamera();
        }
    }

    @Override
    public void onPause() {
        if (mScannerView != null) {
            mScannerView.stopCamera();
        }
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(ScannerContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void handleResult(Result result) {
        // TODO: 5/22/2017 work data scanner qrcode
    }
}
