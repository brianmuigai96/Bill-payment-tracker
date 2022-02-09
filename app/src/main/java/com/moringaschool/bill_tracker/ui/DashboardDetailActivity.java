package com.moringaschool.bill_tracker.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.moringaschool.bill_tracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardDetailActivity {


    @BindView(R.id.btn) Button button;


  

    public void DashboardDetailFragment() {
        // Required empty public constructor
    }


    public static DashboardDetailFragment newInstance() {
        DashboardDetailFragment dashboardDetailFragment = new  DashboardDetailFragment();
        Bundle args = new Bundle();


        return  dashboardDetailFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_dashboard_detail, container, false);
        ButterKnife.bind(this, view);



        return view;
    }
}
}
