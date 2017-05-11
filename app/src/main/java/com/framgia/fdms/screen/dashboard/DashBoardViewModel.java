package com.framgia.fdms.screen.dashboard;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.fdms.BR;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

/**
 * Exposes the data to be used in the Scanner screen.
 */

public class DashBoardViewModel extends BaseObservable implements DashBoardContract.ViewModel {

    private DashBoardContract.Presenter mPresenter;
    private PieData mPieData;
    private Context mContext;

    public DashBoardViewModel(Context context) {
        mContext = context;
        mPieData = new PieData();
    }

    public DashBoardViewModel() {
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(DashBoardContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public PieData getPieData() {
        return mPieData;
    }

    public void setPieData(PieData pieData) {
        mPieData = pieData;
        notifyPropertyChanged(BR.pieData);
    }

    @Override
    public void setDataSet(PieDataSet dataSet) {
        mPieData.setDataSet(dataSet);
        mPieData.setValueFormatter(new PercentFormatter());
    }

    @Override
    public void onDashBoardError(String error) {
        Toast.makeText(mContext, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public String getTitle(int titleRs) {
        return mContext.getString(titleRs);
    }
}
