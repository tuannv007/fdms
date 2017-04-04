package com.framgia.fdms.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framgia.fdms.R;
import com.framgia.fdms.data.DeviceRepository;
import com.framgia.fdms.data.source.DeviceRemoteDataSource;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.databinding.ActivityMainBinding;

/**
 * Main Screen.
 */
public class MainActivity extends AppCompatActivity {
    private MainContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new MainViewModel();
        MainContract.Presenter presenter =
            new MainPresenter(mViewModel,
                new DeviceRepository(new DeviceRemoteDataSource(FDMSServiceClient.getInstance())));
        mViewModel.setPresenter(presenter);
        ActivityMainBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel((MainViewModel) mViewModel);
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
