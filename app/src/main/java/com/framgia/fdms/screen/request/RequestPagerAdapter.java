package com.framgia.fdms.screen.request;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.fdms.R;
import com.framgia.fdms.screen.request.requestmanager.RequestManagerFragment;
import com.framgia.fdms.screen.request.userrequest.UserRequestFragment;

import static com.framgia.fdms.screen.request.RequestPagerAdapter.RequestPage.MANAGER_REQUEST;
import static com.framgia.fdms.screen.request.RequestPagerAdapter.RequestPage.USER_REQUEST;

/**
 * Created by framgia on 19/05/2017.
 */

public class RequestPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 2;
    private Context mContext;

    public RequestPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case MANAGER_REQUEST:
                return RequestManagerFragment.newInstance();
            case USER_REQUEST:
                return UserRequestFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case MANAGER_REQUEST:
                return mContext.getString(R.string.title_manager_request);
            case USER_REQUEST:
                return mContext.getString(R.string.title_my_request);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @IntDef({ MANAGER_REQUEST, USER_REQUEST })
    @interface RequestPage {
        int USER_REQUEST = 0;
        int MANAGER_REQUEST = 1;
    }
}
