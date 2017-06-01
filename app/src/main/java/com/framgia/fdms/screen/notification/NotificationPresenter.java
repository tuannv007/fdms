package com.framgia.fdms.screen.notification;

/**
 * Listens to user actions from the UI ({@link NotificationActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
public final class NotificationPresenter implements NotificationContract.Presenter {
    private static final String TAG = NotificationPresenter.class.getName();

    private final NotificationContract.ViewModel mViewModel;

    public NotificationPresenter(NotificationContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
