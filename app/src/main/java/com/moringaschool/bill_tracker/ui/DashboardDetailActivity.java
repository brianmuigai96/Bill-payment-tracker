package com.moringaschool.bill_tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.moringaschool.bill_tracker.R;

public class DashboardDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_detail);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        Bundle bundle =new Bundle();
        bundle.putString("username", username);
        bundle.putString("password", password);

        DashboardFragment dashboardFragment =new DashboardFragment();
        dashboardFragment.setArguments(bundle);
        FragmentManager fragmentManager =getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentcontainer,dashboardFragment)
                .commit();
    }
}