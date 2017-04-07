package com.framgia.fdms.screen.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.DeviceRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.DeviceRemoteDataSource;
import com.framgia.fdms.databinding.ActivityMainBinding;
import com.framgia.fdms.screen.search.SearchActivity;

/**
 * Main Screen.
 */
public class MainActivity extends AppCompatActivity {
    private MainContract.ViewModel mViewModel;

    public static Intent getInstance(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new MainViewModel(this);
        MainContract.Presenter presenter = new MainPresenter(mViewModel,
                new DeviceRepository(new DeviceRemoteDataSource(FDMSServiceClient.getInstance())));
        mViewModel.setPresenter(presenter);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                startActivity(new Intent(SearchActivity.searchIntent(this)));
                return true;
            case R.id.action_sort_by_category:
                //TODO dev later
                return true;
            case R.id.action_sort_by_date:
                //TODO dev later
                return true;
            case R.id.action_sort_by_status:
                //TODO dev later
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
