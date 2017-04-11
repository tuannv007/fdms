package com.framgia.fdms.screen.device;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.DeviceRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.DeviceRemoteDataSource;
import com.framgia.fdms.databinding.ActivityDeviceBinding;

/**
 * Device Screen.
 */
public class DeviceActivity extends AppCompatActivity {
    private DeviceContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new DeviceViewModel(this);
        DeviceRepository repository =
                new DeviceRepository(new DeviceRemoteDataSource(FDMSServiceClient.getInstance()));
        DeviceContract.Presenter presenter = new DevicePresenter(mViewModel, repository);
        mViewModel.setPresenter(presenter);
        ActivityDeviceBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_device);
        binding.setViewModel((DeviceViewModel) mViewModel);
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
