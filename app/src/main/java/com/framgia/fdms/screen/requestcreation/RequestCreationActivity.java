package com.framgia.fdms.screen.requestcreation;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.fdms.R;
import com.framgia.fdms.databinding.ActivityRequestCreationBinding;

/**
 * Requestcreation Screen.
 */
public class RequestCreationActivity extends AppCompatActivity {

    private RequestCreationContract.ViewModel mViewModel;

    public static Intent getInstance(Context context) {
        return new Intent(context, RequestCreationActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new RequestCreationViewModel(this);

        RequestCreationContract.Presenter presenter = new RequestCreationPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityRequestCreationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_request_creation);
        binding.setViewModel((RequestCreationViewModel) mViewModel);
        setTitle(getString(R.string.title_create_request));
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
