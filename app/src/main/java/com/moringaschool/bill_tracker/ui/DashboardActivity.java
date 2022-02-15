package com.moringaschool.bill_tracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.moringaschool.bill_tracker.adapters.DashboardArrayAdpater;
import com.moringaschool.bill_tracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity  extends AppCompatActivity implements  View.OnClickListener {
    @BindView(R.id.listView) ListView mListView;
    private TextView mUsernameEditText;
    private String [] service = new String[]{"Dstv","Gotv","Rent","Car Insuarance","Water bill","Electricity bill"};
    private String [] status = new String[]{"Paid","Pending","Unpaid","Overdue","Unpaid","Overdue"};
    @BindView(R.id.proceedbutton) MaterialButton mProceedButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_fragment);
        ButterKnife.bind(this);
        mUsernameEditText = findViewById(R.id.UsernameEditText);
        DashboardArrayAdpater adapter = new DashboardArrayAdpater(this, android.R.layout.simple_list_item_1, service, status);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String service = ((TextView) view).getText().toString();
                Toast.makeText(DashboardActivity.this, service, Toast.LENGTH_LONG).show();
            }
        });
//unique naming system


        mProceedButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                if (v==mProceedButton) {
//                passing data from Dashboard activity
                    Intent intent = new Intent(DashboardActivity.this, PaymentActivity.class);
                    intent.putExtra(" payment","payment");
                    startActivity(intent);
                    onBackPressed();
                }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
    }
}
