package com.framgia.fdms.screen.requestdetail;

import android.view.Menu;
import android.view.MenuItem;
import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;

/**
 * Created by tuanbg on 5/24/17.
 */

public interface RequestDetailContract {
    interface ViewModel extends BaseViewModel {
        boolean onCreateOptionsMenu(Menu menu);

        boolean onOptionsItemSelected(MenuItem item);

    }

    interface Presenter extends BasePresenter {

    }
}
