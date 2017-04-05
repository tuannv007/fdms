package com.framgia.fdms.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Device;
import com.framgia.fdms.databinding.DetailDataBinding;

/**
 * Detail Screen.
 */
public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_DEVICE = "EXTRA_DEVICE";

    private DetailContract.ViewModel mViewModel;

    public static Intent getDeviceIntent(Context context, Device device) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_DEVICE, device);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Device device = (Device) getIntent().getSerializableExtra(EXTRA_DEVICE);
        setTitle(device.getName());
        mViewModel = new DetailViewModel(this, device);

        DetailContract.Presenter presenter = new DetailPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        DetailDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel((DetailViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
