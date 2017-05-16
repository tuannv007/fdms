package com.framgia.fdms.screen.listDevice;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.fdms.R;
import com.framgia.fdms.data.source.DeviceRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.DeviceRemoteDataSource;
import com.framgia.fdms.databinding.FragmentListdeviceBinding;

/**
 * ListDevice Screen.
 */
public class ListDeviceFragment extends Fragment {

    private ListDeviceContract.ViewModel mViewModel;

    public static ListDeviceFragment newInstance() {
        return new ListDeviceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ListDeviceViewModel(getActivity());

        ListDeviceContract.Presenter presenter = new ListDevicePresenter(mViewModel,
                new DeviceRepository(new DeviceRemoteDataSource(FDMSServiceClient.getInstance())));
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentListdeviceBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_listdevice, container, false);
        binding.setViewModel((ListDeviceViewModel) mViewModel);
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
