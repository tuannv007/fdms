package com.framgia.fdms.screen.dashboard;

/**
 * Listens to user actions from the UI ({@link DashBoardFragment}), retrieves the data and updates
 * the UI as required.
 */
final class DashBoardPresenter implements DashBoardContract.Presenter {
    private static final String TAG = DashBoardPresenter.class.getName();

    private final DashBoardContract.ViewModel mViewModel;

    public DashBoardPresenter(DashBoardContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
