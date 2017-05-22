package com.framgia.fdms.screen.request;

import android.view.View;
import com.framgia.fdms.screen.request.userrequest.UserRequestAdapter;

/**
 * Created by framgia on 22/05/2017.
 */

public interface OnMenuClickListenner {
    void onMenuClick(View v, UserRequestAdapter.RequestModel request);
}
