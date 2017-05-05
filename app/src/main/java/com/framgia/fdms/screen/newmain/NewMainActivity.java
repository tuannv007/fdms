package com.framgia.fdms.screen.newmain;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.fdms.R;
import com.framgia.fdms.databinding.ActivityNewmainBinding;

/**
 * Newmain Screen.
 */
public class NewMainActivity extends AppCompatActivity {
    private NewMainContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewmainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_newmain);
        mViewModel = new NewMainViewModel(new ViewPagerAdapter(getSupportFragmentManager()));
        NewMainContract.Presenter presenter = new NewMainPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        binding.setViewModel((NewMainViewModel) mViewModel);
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
