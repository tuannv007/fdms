package com.framgia.fdms.screen.request.requestmanager;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.fdms.R;
import com.framgia.fdms.databinding.FragmentRequestManagerBinding;

/**
 * RequestManager Screen.
 */
public class RequestManagerFragment extends Fragment {

    private RequestManagerContract.ViewModel mViewModel;

    public static RequestManagerFragment newInstance() {
        return new RequestManagerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new RequestManagerViewModel();

        RequestManagerContract.Presenter presenter = new RequestManagerPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentRequestManagerBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_request_manager, container, false);
        binding.setViewModel((RequestManagerViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
