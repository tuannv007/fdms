package com.framgia.fdms.screen.request.requestmanager;

/**
 * Listens to user actions from the UI ({@link RequestManagerFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
final class RequestManagerPresenter implements RequestManagerContract.Presenter {
    private static final String TAG = RequestManagerPresenter.class.getName();

    private final RequestManagerContract.ViewModel mViewModel;

    public RequestManagerPresenter(RequestManagerContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
