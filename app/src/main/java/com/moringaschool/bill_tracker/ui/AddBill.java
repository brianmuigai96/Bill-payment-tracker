package com.moringaschool.bill_tracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.models.Bill;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBill extends AppCompatActivity {
    @BindView(R.id.billName) EditText mBillName;
    @BindView(R.id.amount) EditText mAmount;
    @BindView(R.id.dueDate) EditText mdueDate;
    @BindView(R.id.description) EditText mDescription;
    @BindView(R.id.createUserButton) Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
        ButterKnife.bind(this);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = mBillName.getText().toString().trim();
                final String amount = mAmount.getText().toString().trim();
                String dueDAte = mdueDate.getText().toString().trim();
                String description = mDescription.getText().toString().trim();
                Bill bill = new Bill(name,amount,dueDAte,description);
            }
        });
    }
}