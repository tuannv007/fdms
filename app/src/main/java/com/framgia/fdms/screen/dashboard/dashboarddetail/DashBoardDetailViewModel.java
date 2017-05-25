package com.framgia.fdms.screen.dashboard.dashboarddetail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;
import android.widget.Toast;
import com.framgia.fdms.BR;
import com.framgia.fdms.R;
import com.framgia.fdms.data.model.Dashboard;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import java.util.ArrayList;
import java.util.List;

import static com.framgia.fdms.screen.dashboard.dashboarddetail.DashBoardDetailFragment
        .DEVICE_DASHBOARD;
import static com.framgia.fdms.screen.dashboard.dashboarddetail.DashBoardDetailFragment
        .REQUEST_DASHBOARD;

/**
 * Exposes the data to be used in the Scanner screen.
 */

public class DashBoardDetailViewModel extends BaseObservable
        implements DashBoardDetailContract.ViewModel {

    private static final float PIE_DATA_SLICE_SPACE = 3f;
    private static final float PIE_DATA_SLECTION_SHIFT = 5f;
    private DashBoardDetailContract.Presenter mPresenter;
    private PieData mPieData;
    private Context mContext;
    private int mTotal;
    private DashBoardDetailAdapter mAdapter;
    private String mDashboardTitle;

    public DashBoardDetailViewModel(Context context, int dashboardType) {
        mContext = context;
        mPieData = new PieData();
        mAdapter = new DashBoardDetailAdapter(mContext, new ArrayList<Dashboard>(), this);
        initDashboardTitle(dashboardType);
    }

    private void initDashboardTitle(int dashboardType) {
        if (dashboardType == DEVICE_DASHBOARD) {
            setDashboardTitle(mContext.getString(R.string.title_top_devices));
        } else if (dashboardType == REQUEST_DASHBOARD) {
            setDashboardTitle(mContext.getString(R.string.title_top_requests));
        }
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
    public void setPresenter(DashBoardDetailContract.Presenter presenter) {
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
        mPieData = new PieData(dataSet);
        setPieData(mPieData);
    }

    @Override
    public void onDashBoardError(String error) {
        Toast.makeText(mContext, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDashBoardLoaded(List<Dashboard> dashboards) {
        int total = 0;
        List<Integer> colors = new ArrayList<Integer>();
        List<PieEntry> values = new ArrayList<PieEntry>();

        for (Dashboard dashboard : dashboards) {
            total += dashboard.getCount();
        }

        for (int i = 0; i < dashboards.size(); i++) {
            Dashboard dashboard = dashboards.get(i);
            float percent = (float) dashboard.getCount() / total * 100f;
            values.add(new PieEntry(percent, dashboard.getTitle(), i));
            colors.add(Color.parseColor(dashboard.getBackgroundColor()));
        }

        PieDataSet dataSet = new PieDataSet(values, mContext.getString(R.string.title_chart));
        dataSet.setSliceSpace(PIE_DATA_SLICE_SPACE);
        dataSet.setSelectionShift(PIE_DATA_SLECTION_SHIFT);
        dataSet.setColors(colors);

        setDataSet(dataSet);
        setTotal(total);
        mAdapter.onUpdatePage(dashboards);
    }

    @Override
    public void getData() {
        mPresenter.getData();
    }

    public void setTotal(int total) {
        mTotal = total;
        notifyPropertyChanged(BR.total);
    }

    @Bindable
    public int getTotal() {
        return mTotal;
    }

    @Bindable
    public DashBoardDetailAdapter getAdapter() {
        return mAdapter;
    }

    @Bindable
    public String getDashboardTitle() {
        return mDashboardTitle;
    }

    public void setDashboardTitle(String dashboardTitle) {
        mDashboardTitle = dashboardTitle;
        notifyPropertyChanged(BR.dashboardTitle);
    }
}
