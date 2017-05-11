package com.framgia.fdms.screen.dashboard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.fdms.R;
import com.framgia.fdms.data.source.DeviceRepository;
import com.framgia.fdms.data.source.RequestRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.DeviceRemoteDataSource;
import com.framgia.fdms.data.source.remote.RequestRemoteDataSource;
import com.framgia.fdms.databinding.FragmentDashBoardBinding;

/**
 * Scanner Screen.
 */
public class DashBoardFragment extends Fragment {
    public static final String EXTRA_DASHBORAD_TYPE = "EXTRA_DASHBORAD_TYPE";
    public static final int DEVICE_DASHBOARD = 0;
    public static final int REQUEST_DASHBOARD = 1;

    private DashBoardContract.ViewModel mViewModel;

    public static DashBoardFragment newInstance(int dashboradType) {
        DashBoardFragment boardFragment = new DashBoardFragment();
        Bundle args = new Bundle();
        args.putInt(EXTRA_DASHBORAD_TYPE, dashboradType);
        boardFragment.setArguments(args);
        return boardFragment;
    }

    public static DashBoardFragment newInstance() {
        return new DashBoardFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int dashboradType = DEVICE_DASHBOARD;
        if (savedInstanceState != null) {
            dashboradType = savedInstanceState.getInt(EXTRA_DASHBORAD_TYPE);
        }

        mViewModel = new DashBoardViewModel(getContext());
        DashBoardContract.Presenter presenter = new DashBoardPresenter(mViewModel,
                new DeviceRepository(new DeviceRemoteDataSource(FDMSServiceClient.getInstance())),
                new RequestRepository(new RequestRemoteDataSource(FDMSServiceClient.getInstance())),
                dashboradType);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentDashBoardBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_dash_board, container, false);
        binding.setViewModel((DashBoardViewModel) mViewModel);
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
