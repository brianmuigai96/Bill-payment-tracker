package com.moringaschool.bill_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity  extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;
    private TextView UsernameEditText;
    private String [] service = new String[]{"Dstv","Gotv","Rent","Car Insuarance","Water bill","Electricity bill"};
    private String [] status = new String[]{"Paid","Pending","Unpaid","Overdue","Unpaid","Overdue"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        ButterKnife.bind(this);
        String payment = intent.getStringExtra("payment");

    }
}
