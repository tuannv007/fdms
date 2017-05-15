package com.framgia.fdms.screen.dashboard;

/**
 * Listens to user actions from the UI ({@link DashboardFragment}), retrieves the data and updates
 * the UI as required.
 */
final class DashboardPresenter implements DashboardContract.Presenter {
    private static final String TAG = DashboardPresenter.class.getName();

    private final DashboardContract.ViewModel mViewModel;

    public DashboardPresenter(DashboardContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
