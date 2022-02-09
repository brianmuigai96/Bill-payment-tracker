package com.moringaschool.bill_tracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.adapters.DashboardArrayAdpater;

import java.security.PrivateKey;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.listView)
    ListView mListView;
    private String[] service = new String[]{"Dstv", "Gotv", "Rent", "Car Insuarance", "Water bill", "Electricity bill"};
    private String[] status = new String[]{"Paid", "Pending", "Unpaid", "Overdue", "Unpaid", "Overdue"};
    @BindView(R.id.proceedbutton)
    MaterialButton mProceedButton;
    @BindView(R.id.UsernameEditText)
    TextView mUsernameEditText;
    private String passwword;
    private String username;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_dashboard_fragment, container, false);
        ButterKnife.bind(this, view);

        DashboardArrayAdpater adapter = new DashboardArrayAdpater(getContext(), android.R.layout.simple_list_item_1, service, status);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String service = ((TextView) view).getText().toString();
                Toast.makeText(getContext(), service, Toast.LENGTH_LONG).show();
            }
        });

        mUsernameEditText.setText("Here are all the status of your bills: " + username);

        mProceedButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle =getArguments();
        username = bundle.getString("username");
        passwword = bundle.getString("password");

    }

    @Override
    public void onClick(View v) {
        if (v == mProceedButton) {
//                passing data from Dashboard activity
            Intent intent = new Intent(getContext(), PaymentActivity.class);
            intent.putExtra(" payment", "payment");
            startActivity(intent);

        }
    }
}
