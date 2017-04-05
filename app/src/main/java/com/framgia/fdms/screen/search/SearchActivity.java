package com.framgia.fdms.screen.search;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.DeviceRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.DeviceRemoteDataSource;
import com.framgia.fdms.databinding.ActivitySearchBinding;

/**
 * Search Screen.
 */
public class SearchActivity extends AppCompatActivity {

    private SearchContract.ViewModel mViewModel;

    public static Intent searchIntent(Context context) {
        return new Intent(context, SearchActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new SearchViewModel(this);
        setTitle(getString(R.string.title_search));

        SearchContract.Presenter presenter = new SearchPresenter(mViewModel,
                new DeviceRepository(new DeviceRemoteDataSource(FDMSServiceClient.getInstance())));
        mViewModel.setPresenter(presenter);

        ActivitySearchBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_search);
        binding.setViewModel((SearchViewModel) mViewModel);
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
