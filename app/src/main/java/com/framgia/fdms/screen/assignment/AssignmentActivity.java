package com.framgia.fdms.screen.assignment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.framgia.fdms.R;
import com.framgia.fdms.databinding.ActivityAssignmentBinding;

/**
 * Assignment Screen.
 */
public class AssignmentActivity extends AppCompatActivity {

    private AssignmentContract.ViewModel mViewModel;

    public static Intent getInstance(Context context) {
        Intent intent = new Intent(context, AssignmentActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new AssignmentViewModel(this);

        AssignmentContract.Presenter presenter = new AssignmentPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityAssignmentBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_assignment);
        binding.setViewModel((AssignmentViewModel) mViewModel);
        setTitle(getString(R.string.title_assignment));
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
