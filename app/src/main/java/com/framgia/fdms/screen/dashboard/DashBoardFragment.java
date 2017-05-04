package com.framgia.fdms.screen.dashboard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.fdms.R;
import com.framgia.fdms.databinding.FragmentDashBoardBinding;

/**
 * Scanner Screen.
 */
public class DashBoardFragment extends Fragment {

    private DashBoardContract.ViewModel mViewModel;

    public static DashBoardFragment newInstance() {
        return new DashBoardFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new DashBoardViewModel();
        DashBoardContract.Presenter presenter = new DashBoardPresenter(mViewModel);
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
