package com.framgia.fdms.screen.requestdetail;

import android.util.Log;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Request;
import com.framgia.fdms.data.source.CategoryRepository;
import com.framgia.fdms.data.source.RequestRepository;
import com.framgia.fdms.data.source.api.service.FDMSServiceClient;
import com.framgia.fdms.data.source.remote.CategoryRemoteDataSource;
import java.util.List;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tuanbg on 5/26/17.
 */

public class RequestDetailPresenter implements RequestDetailContract.Presenter {
    private RequestDetailContract.ViewModel mViewModel;
    private CategoryRepository mCategoryRepository;
    private CompositeSubscription mSubscription;
    private RequestRepository mRequestRepository;
    private Request mRequest;

    public RequestDetailPresenter(RequestDetailContract.ViewModel viewModel, Request request,
            RequestRepository repository) {
        mViewModel = viewModel;
        mRequest = request;
        mSubscription = new CompositeSubscription();
        mCategoryRepository = new CategoryRepository(
                new CategoryRemoteDataSource(FDMSServiceClient.getInstance()));
        mRequestRepository = repository;
    }

    @Override
    public void getListCategory() {
        Subscription subscription = mCategoryRepository.getListCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mViewModel.showProgressbar();
                    }
                })
                .subscribe(new Subscriber<List<Category>>() {
                    @Override
                    public void onCompleted() {
                        mViewModel.hideProgressbar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.hideProgressbar();
                        mViewModel.onLoadError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Category> categories) {
                        mViewModel.onGetCategorySuccess(categories);
                    }
                });
        mSubscription.add(subscription);
    }

    @Override
    public void updateRequest(int requestId, Request request) {
        Log.e("haha", request.getDevices().toString());// [DeviceRequest{mId=1, mDescription='ddaâ', mNumber=6, mCategoryName='camera'}]
        Subscription subscription = mRequestRepository.updateRequest(requestId, request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mViewModel.showProgressbar();
                    }
                })
                .subscribe(new Subscriber<Request>() {
                    @Override
                    public void onCompleted() {
                        mViewModel.hideProgressbar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onLoadError(e.getCause().toString());
                    }

                    @Override
                    public void onNext(Request request) {
                        mViewModel.editRequestSuccess(request);
                    }
                });
        mSubscription.add(subscription);
    }

    @Override
    public void editRequest() {
        updateRequest(mRequest.getId(), mRequest);
    }

    @Override
    public void onStart() {
        getListCategory();
    }

    @Override
    public void onStop() {

    }
}
