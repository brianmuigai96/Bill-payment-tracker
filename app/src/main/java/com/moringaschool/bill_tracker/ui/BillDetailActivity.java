package com.moringaschool.bill_tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.models.Bill;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BillDetailActivity extends AppCompatActivity {
    @BindView(R.id.textView10) TextView mAmount;
    @BindView(R.id.name) TextView mName;
    @BindView(R.id.description) TextView mDescription;
    @BindView(R.id.deleteBill) TextView mDBill;
    @BindView(R.id.textView7) TextView mViewName;
    @BindView(R.id.textView8) TextView mViewDate;
    @BindView(R.id.textView9) TextView mViewDescription;
    @BindView(R.id.textView3) TextView mViewAmount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        ButterKnife.bind(this);
        Bill bill = (Bill) getIntent().getSerializableExtra("Bill");
        mViewAmount.setText(bill.getAmount());
        mViewName.setText(bill.getBillName());
        mViewDate.setText(bill.getDueDate());
        mViewDescription.setText(bill.getDescription());

    }

        }
