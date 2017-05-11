package com.framgia.fdms.screen.dashboard;

import android.content.Context;
import com.framgia.fdms.BasePresenter;
import com.framgia.fdms.BaseViewModel;
import com.framgia.fdms.data.model.Dashboard;
import com.framgia.fdms.data.model.Respone;
import com.github.mikephil.charting.data.PieDataSet;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DashBoardContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void setDataSet(PieDataSet dataSet);

        void onDashBoardError(String error);

        String getTitle(int titleRs);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getDeviceDashboard();

        void getRequestDashboard();

        void onDashBoardLoaded(Respone<List<Dashboard>> listRespone);
    }
}
