package com.framgia.fdms.screen.request;

/**
 * Listens to user actions from the UI ({@link RequestFragment}), retrieves the data and updates
 * the UI as required.
 */
final class RequestPresenter implements RequestContract.Presenter {
    private static final String TAG = RequestPresenter.class.getName();

    private final RequestContract.ViewModel mViewModel;

    public RequestPresenter(RequestContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
