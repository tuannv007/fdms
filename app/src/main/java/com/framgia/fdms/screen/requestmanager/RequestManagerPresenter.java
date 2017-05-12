package com.framgia.fdms.screen.requestmanager;

import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.source.RequestRepositoryContract;
import java.util.List;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static com.framgia.fdms.utils.Constant.ALL_RELATIVE_ID;
import static com.framgia.fdms.utils.Constant.ALL_REQUEST_STATUS_ID;
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
    private RequestRepositoryContract mRequestRepository;

    public RequestManagerPresenter(RequestManagerContract.ViewModel viewModel,
            RequestRepositoryContract deviceRepository) {
        mViewModel = viewModel;
        mSubscription = new CompositeSubscription();
        mRequestRepository = deviceRepository;
    }

    @Override
    public void onLoadMore() {
        mPage++;
        getListData(mPage, PER_PAGE);
    }

    @Override
    public void getListData(int page, int perPage) {

    }

    @Override
    public void onStart() {
        getMyRequest(ALL_REQUEST_STATUS_ID, ALL_RELATIVE_ID, mPage, PER_PAGE);
    }

    @Override
    public void onStop() {
        mSubscription.clear();
    }

    @Override
    public void getMyRequest(int requestStatusId, int relativeId, int perPage, int page) {
        Subscription subscription =
                mRequestRepository.getMyRequest(requestStatusId, relativeId, page, perPage)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {
                                mViewModel.showProgressbar();
                            }
                        })
                        .subscribe(new Subscriber<List<Request>>() {
                            @Override
                            public void onCompleted() {
                                mViewModel.hideProgressbar();
                            }

                            @Override
                            public void onError(Throwable e) {
                                mViewModel.onErrorLoadPage(e.getMessage());
                            }

                            @Override
                            public void onNext(List<Request> requests) {
                                mViewModel.onPageLoad(requests);
                            }
                        });

        mSubscription.add(subscription);
    }
}
