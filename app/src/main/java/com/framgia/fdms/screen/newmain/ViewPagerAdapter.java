package com.framgia.fdms.screen.newmain;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.fdms.screen.dashboard.DashboardFragment;
import com.framgia.fdms.screen.listDevice.ListDeviceFragment;
import com.framgia.fdms.screen.request.userrequest.UserRequestFragment;

import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_DASH_BOARD;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_DEVICE_MANAGER;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_PROFILE;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_REQUEST_MANAGER;

/**
 * Created by beepi on 25/04/2017.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final int TAB_NUMBER = 4;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TAB_DASH_BOARD:
                // todo direct to dashboard screen
                return DashboardFragment.newInstance();
            case TAB_REQUEST_MANAGER:
                return UserRequestFragment.newInstance();
            case TAB_DEVICE_MANAGER:
                return ListDeviceFragment.newInstance();
            case TAB_PROFILE:
                // todo direct to profile screen
                return DashboardFragment.newInstance();
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
