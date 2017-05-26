package com.framgia.fdms.screen.requestdetail;

import android.view.Menu;
import android.view.MenuItem;
import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Category;
import com.framgia.fdms.data.model.Request;
import java.util.List;

/**
 * Created by tuanbg on 5/24/17.
 */

public interface RequestDetailContract {
    interface ViewModel extends BaseViewModel<RequestDetailContract.Presenter> {
        boolean onCreateOptionsMenu(Menu menu);

        boolean onOptionsItemSelected(MenuItem item);

        void showProgressbar();

        void hideProgressbar();

        void onLoadError(String message);

        void onGetCategorySuccess(List<Category> categories);

        void editRequestSuccess(Request request);
    }

    interface Presenter extends BasePresenter {
        void getListCategory();

        void updateRequest(int requestId, Request request);

        void editRequest();
    }
}
