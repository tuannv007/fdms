package com.framgia.fdms.screen.requestdetail;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Category;
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

        void onActivityResult(int requestCode, int resultCode, Intent data);
    }

    interface Presenter extends BasePresenter {

    }
}
