package com.moringaschool.bill_tracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.bill_tracker.Constants;
import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.adapters.BillAdapter;
import com.moringaschool.bill_tracker.models.Bill;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.recyclerView) RecyclerView mRecylerView;
    @BindView(R.id.proceedbutton) MaterialButton mProceedButton;
    @BindView(R.id.UsernameEditText) TextView mUsernameEditText;
    private DatabaseReference billReference;
    private String passwword;
    private String username;




    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_dashboard_fragment, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        mRecylerView.setLayoutManager(linearLayoutManager);
        billReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_BILL);
        billReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
              ArrayList<Bill> mbill =new ArrayList<>();

                Toast.makeText(getContext(),"successful",Toast.LENGTH_LONG).show();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    mbill.add(postSnapshot.getValue(Bill.class));
                    mRecylerView.setAdapter(new BillAdapter(getContext(),mbill));

                }

            }

            @Override
            public void onCancelled( DatabaseError error) {
                Toast.makeText(getContext(),"error",Toast.LENGTH_LONG).show();

            }
        });

        mProceedButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle =getArguments();
        username = bundle.getString("username");
        passwword = bundle.getString("password");
    }

    @Override
    public void onClick(View v) {
        if (v == mProceedButton) {
//                passing data from Dashboard activity
            Intent intent = new Intent(getContext(), AddBill.class);
            intent.putExtra(" payment", "payment");
            startActivity(intent);

        }
    }
}
