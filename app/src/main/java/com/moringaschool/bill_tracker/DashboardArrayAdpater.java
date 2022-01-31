package com.moringaschool.bill_tracker;

import android.content.Context;
import android.widget.ArrayAdapter;

public class DashboardArrayAdpater extends ArrayAdapter {
    private Context mContext;
    private String  [] mService;
    private String [] mStatus;
    public DashboardArrayAdpater(Context mContext, int resource, String[] mService, String[] mStatus) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mService= mService;
        this.mStatus = mStatus;
    }

}
