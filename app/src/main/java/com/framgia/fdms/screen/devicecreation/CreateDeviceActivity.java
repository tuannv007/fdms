package com.framgia.fdms.screen.devicecreation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.CategoryRepository;
import com.framgia.fdms.data.source.DeviceRepository;
import com.framgia.fdms.data.source.StatusRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.CategoryRemoteDataSource;
import com.framgia.fdms.data.source.remote.DeviceRemoteDataSource;
import com.framgia.fdms.data.source.remote.StatusRemoteDataSource;
import com.framgia.fdms.databinding.ActivityCreatedeviceBinding;

/**
 * Createdevice Screen.
 */
public class CreateDeviceActivity extends AppCompatActivity {

    private CreateDeviceContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new CreateDeviceViewModel(this);

        DeviceRepository deviceRepository =
                new DeviceRepository(new DeviceRemoteDataSource(FDMSServiceClient.getInstance()));
        StatusRepository statusRepository =
                new StatusRepository(new StatusRemoteDataSource(FDMSServiceClient.getInstance()));
        CategoryRepository categoryRepository =
                new CategoryRepository(new CategoryRemoteDataSource(FDMSServiceClient.getInstance()));
        CreateDeviceContract.Presenter presenter = new CreateDevicePresenter(mViewModel,
                deviceRepository, statusRepository, categoryRepository);
        mViewModel.setPresenter(presenter);

        ActivityCreatedeviceBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_createdevice);
        binding.setViewModel((CreateDeviceViewModel) mViewModel);
        setTitle(R.string.title_create_device);
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
