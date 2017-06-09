package com.framgia.fdms.screen.assignment;

/**
 * Listens to user actions from the UI ({@link AssignmentActivity}), retrieves the data and updates
 * the UI as required.
 */
final class AssignmentPresenter implements AssignmentContract.Presenter {
    private static final String TAG = AssignmentPresenter.class.getName();

    private final AssignmentContract.ViewModel mViewModel;

    public AssignmentPresenter(AssignmentContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
