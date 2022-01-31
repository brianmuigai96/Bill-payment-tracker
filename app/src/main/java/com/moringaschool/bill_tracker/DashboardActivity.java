package com.moringaschool.bill_tracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity  extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        String payment = intent.getStringExtra("payment");

    }
}
