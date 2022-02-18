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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.bill_tracker.Constants;
import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.adapters.DashboardArrayAdpater;

import java.security.PrivateKey;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.proceedbutton) MaterialButton mProceedButton;
    @BindView(R.id.UsernameEditText) TextView mUsernameEditText;
    private DatabaseReference billReference;
    private String passwword;
    private String username;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_dashboard_fragment, container, false);
        ButterKnife.bind(this, view);
        billReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_BILL);
        billReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
