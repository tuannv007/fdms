package com.framgia.fdms.screen.dashboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.fdms.screen.dashboard.dashboarddetail.DashBoardDetailFragment;

import static com.framgia.fdms.screen.dashboard.DashboardViewModel.Tab.TAB_DEVIVE_DASH_BOARD;
import static com.framgia.fdms.screen.dashboard.DashboardViewModel.Tab.TAB_REQUEST_DASH_BOARD;
import static com.framgia.fdms.screen.dashboard.dashboarddetail.DashBoardDetailFragment
        .DEVICE_DASHBOARD;
import static com.framgia.fdms.screen.dashboard.dashboarddetail.DashBoardDetailFragment
        .REQUEST_DASHBOARD;

/**
 * Created by MyPC on 15/05/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final int TAB_NUMBER = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TAB_DEVIVE_DASH_BOARD:
                return DashBoardDetailFragment.newInstance(DEVICE_DASHBOARD);
            case TAB_REQUEST_DASH_BOARD:
                return DashBoardDetailFragment.newInstance(REQUEST_DASHBOARD);
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_NUMBER;
    }
}
