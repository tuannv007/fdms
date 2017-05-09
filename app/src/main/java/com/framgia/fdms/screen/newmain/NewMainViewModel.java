package com.framgia.fdms.screen.newmain;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.hardware.Camera;
import android.support.annotation.IntDef;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.framgia.fdms.BR;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Device;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_DASH_BOARD;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_DEVICE_MANAGER;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_REQUEST_MANAGER;

/**
 * Exposes the data to be used in the Newmain screen.
 */
public class NewMainViewModel extends BaseObservable implements NewMainContract.ViewModel {
    private NewMainContract.Presenter mPresenter;
    private ViewPagerAdapter mPagerAdapter;
    private int mTab = TAB_DASH_BOARD;
    private AppCompatActivity mActivity;

    public NewMainViewModel(ViewPagerAdapter adapter, AppCompatActivity activity) {
        mPagerAdapter = adapter;
        mActivity = activity;
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
    public void setPresenter(NewMainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public ViewPagerAdapter getPagerAdapter() {
        return mPagerAdapter;
    }

    @Bindable
    public int getTab() {
        return mTab;
    }

    public void setTab(int tab) {
        mTab = tab;
        notifyPropertyChanged(BR.tab);
    }

    public void onDirectChildTab(@Tab int tab, ViewPager viewPager) {
        if (mPagerAdapter == null) return;
        viewPager.setCurrentItem(tab);
    }

    public void onDirectQrCodeScanner() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(mActivity);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setPrompt(mActivity.getResources().getString(R.string.title_scanning));
        intentIntegrator.setCameraId(Camera.CameraInfo.CAMERA_FACING_BACK);
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result == null) return;
        String contentResult = result.getContents();
        if (contentResult == null) {
            onFailScanner();
        } else {
            getResult(contentResult);
        }
    }

    @Override
    public void onGetDecodeSuccess(Device device) {
        // todo direct to detail device screen
        Snackbar.make(mActivity.findViewById(android.R.id.content), device.getDeviceCategoryName(), Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onGetDeviceError(String error) {
        Snackbar.make(mActivity.findViewById(android.R.id.content), error, Snackbar.LENGTH_LONG)
                .show();
    }

    private void onFailScanner() {
        Snackbar.make(mActivity.findViewById(android.R.id.content), R.string.title_failure_scanner,
                Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void getResult(String resultQrCode) {
        if (mPresenter == null) return;
        mPresenter.getDevice(resultQrCode);
    }

    @IntDef({
            TAB_DASH_BOARD, TAB_REQUEST_MANAGER, TAB_DEVICE_MANAGER, Tab.TAB_PROFILE
    })
    public @interface Tab {
        int TAB_DASH_BOARD = 0;
        int TAB_REQUEST_MANAGER = 1;
        int TAB_DEVICE_MANAGER = 2;
        int TAB_PROFILE = 3;
    }
}
