package com.framgia.fdms.screen.devicedetail;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.screen.historydetail.DeviceDetailHistoryFragment;
import com.framgia.fdms.screen.usinghistory.DeviceUsingHistoryFragment;

import static com.framgia.fdms.screen.devicedetail.DeviceDetailPagerAdapter.DeviceDetailPage
        .DEVICE_HISTORY;
import static com.framgia.fdms.screen.devicedetail.DeviceDetailPagerAdapter.DeviceDetailPage
        .DEVICE_INFOMATION;
import static com.framgia.fdms.screen.devicedetail.DeviceDetailPagerAdapter.DeviceDetailPage
        .DEVICE_USING_HISTORY;

/**
 * Created by MyPC on 23/05/2017.
 */

public class DeviceDetailPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 3;
    private Context mContext;

    public DeviceDetailPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case DEVICE_INFOMATION:
                return DeviceUsingHistoryFragment.newInstance();
            case DEVICE_HISTORY:
                return DeviceDetailHistoryFragment.newInstance();
            case DEVICE_USING_HISTORY:
                return DeviceUsingHistoryFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case DEVICE_INFOMATION:
                return mContext.getString(R.string.title_device_infomation);
            case DEVICE_HISTORY:
                return mContext.getString(R.string.title_device_history);
            case DEVICE_USING_HISTORY:
                return mContext.getString(R.string.title_using_history);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @IntDef({ DEVICE_INFOMATION, DEVICE_HISTORY, DEVICE_USING_HISTORY })
    public @interface DeviceDetailPage {
        int DEVICE_INFOMATION = 0;
        int DEVICE_HISTORY = 1;
        int DEVICE_USING_HISTORY = 2;
    }
}
