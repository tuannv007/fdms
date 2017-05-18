package com.framgia.fdms.screen.requestcreation;

/**
 * Listens to user actions from the UI ({@link RequestCreationActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
final class RequestCreationPresenter implements RequestCreationContract.Presenter {
    private static final String TAG = RequestCreationPresenter.class.getName();

    private final RequestCreationContract.ViewModel mViewModel;

    public RequestCreationPresenter(RequestCreationContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
