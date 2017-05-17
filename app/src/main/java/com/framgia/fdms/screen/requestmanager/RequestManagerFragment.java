package com.framgia.fdms.screen.requestmanager;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.RequestRepository;
import com.framgia.fdms.data.source.StatusRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.RequestRemoteDataSource;
import com.framgia.fdms.data.source.remote.StatusRemoteDataSource;
import com.framgia.fdms.databinding.FragmentRequestmanagerBinding;

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
        mViewModel = new RequestManagerViewModel(getActivity());
        RequestManagerContract.Presenter presenter = new RequestManagerPresenter(mViewModel,
                RequestRepository.getInstant(
                        new RequestRemoteDataSource(FDMSServiceClient.getInstance())),
                new StatusRepository(new StatusRemoteDataSource(FDMSServiceClient.getInstance())));
        mViewModel.setPresenter(presenter);
        mViewModel.getData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentRequestmanagerBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_requestmanager, container,
                        false);
        binding.setViewModel((RequestManagerViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
