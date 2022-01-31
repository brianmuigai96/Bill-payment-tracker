package com.moringaschool.bill_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity  extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;
    private TextView mUsernameEditText;
    private String [] service = new String[]{"Dstv","Gotv","Rent","Car Insuarance","Water bill","Electricity bill"};
    private String [] status = new String[]{"Paid","Pending","Unpaid","Overdue","Unpaid","Overdue"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        mUsernameEditText=findViewById(R.id.UsernameEditText);
        DashboardArrayAdpater adapter = new DashboardArrayAdpater(this,android.R.layout.simple_list_item_1, service, status);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String service = ((TextView)view).getText().toString();
                Toast.makeText(DashboardActivity.this, service, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent= getIntent();
        String username = intent.getStringExtra("username");
        mUsernameEditText.setText("Here are all the status of your bills: " + username);
        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==mProceedButton) {
//                passing data from Dashboard activity
                    Intent intent = new Intent(DashboardActivity.this, PaymentActivity.class);
                    intent.putExtra("Username", username);
                    startActivity(intent);
                    onBackPressed();
                }
            }
        });

    }
}
