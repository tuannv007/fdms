package com.framgia.fdms.screen.requestmanager;

import com.framgia.fdms.data.source.DeviceRepository;
import rx.subscriptions.CompositeSubscription;

import static com.framgia.fdms.utils.Constant.FIRST_PAGE;
import static com.framgia.fdms.utils.Constant.PER_PAGE;

/**
 * Listens to user actions from the UI ({@link RequestManagerFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
final class RequestManagerPresenter implements RequestManagerContract.Presenter {
    private int mPage = FIRST_PAGE;
    private final RequestManagerContract.ViewModel mViewModel;
    private CompositeSubscription mSubscription;
    private DeviceRepository mDeviceRepository;

    public RequestManagerPresenter(RequestManagerContract.ViewModel viewModel,
            DeviceRepository deviceRepository) {
        mViewModel = viewModel;
        mSubscription = new CompositeSubscription();
        mDeviceRepository = deviceRepository;
    }

    @Override
    public void onLoadMore() {
        mPage++;
        getListData(mPage, PER_PAGE);
    }

    @Override
    public void getListData(int page, int perPage) {
        // add data
    }

    @Override
    public void onStart() {
        getListData(mPage, PER_PAGE);
    }

    @Override
    public void onStop() {
        mSubscription.clear();
    }
}
