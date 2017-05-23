package com.framgia.fdms.screen.returndevice;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.StatusRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.StatusRemoteDataSource;
import com.framgia.fdms.databinding.ActivityReturnDeviceBinding;

/**
 * ReturnDevice Screen.
 */
public class ReturnDeviceActivity extends AppCompatActivity {

    private ReturnDeviceContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ReturnDeviceViewModel(this);

        ReturnDeviceContract.Presenter presenter = new ReturnDevicePresenter(mViewModel,
                new StatusRepository(new StatusRemoteDataSource(FDMSServiceClient.getInstance())));
        mViewModel.setPresenter(presenter);

        ActivityReturnDeviceBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_return_device);
        binding.setViewModel((ReturnDeviceViewModel) mViewModel);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
