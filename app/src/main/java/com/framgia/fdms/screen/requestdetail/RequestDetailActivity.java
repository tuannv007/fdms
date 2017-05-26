package com.framgia.fdms.screen.requestdetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.source.RequestRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.RequestRemoteDataSource;
import com.framgia.fdms.databinding.ActivityRequestDetailBinding;

import static com.framgia.fdms.utils.Constant.BundleRequest.BUND_REQUEST;

/**
 * Created by tuanbg on 5/24/17.
 */

public class RequestDetailActivity extends AppCompatActivity {
    private ActivityRequestDetailBinding mBinding;
    private Toolbar mToolbar;
    private RequestDetailContract.ViewModel mViewModel;

    public static Intent newInstance(Context context, Request request) {
        Intent intent = new Intent(context, RequestDetailActivity.class);
        intent.putExtra(BUND_REQUEST, request);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_request_detail);
        mBinding.setRequest(getRequestFromIntent());
        mViewModel = new RequestDetailViewModel(this, getRequestFromIntent().getDevices());
        RequestDetailContract.Presenter presenter =
                new RequestDetailPresenter(mViewModel, getRequestFromIntent(),
                        new RequestRepository(
                                new RequestRemoteDataSource(FDMSServiceClient.getInstance())));
        mViewModel.setPresenter(presenter);
        mBinding.setViewModel((RequestDetailViewModel) mViewModel);
        initToolbar();
    }

    public Request getRequestFromIntent() {
        return (Request) getIntent().getSerializableExtra(BUND_REQUEST);
    }

    public void initToolbar() {
        mToolbar = mBinding.toolbar;
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() == null) return;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mViewModel.onCreateOptionsMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mViewModel.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
