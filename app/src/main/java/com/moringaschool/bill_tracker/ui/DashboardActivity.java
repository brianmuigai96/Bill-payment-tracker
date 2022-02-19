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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.bill_tracker.Constants;
import com.moringaschool.bill_tracker.adapters.BillAdapter;
import com.moringaschool.bill_tracker.adapters.DashboardArrayAdpater;
import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.models.Bill;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity  extends AppCompatActivity implements  View.OnClickListener {
    @BindView(R.id.recyclerView) RecyclerView mRecylerView;
    @BindView(R.id.proceedbutton) MaterialButton mProceedButton;
    @BindView(R.id.UsernameEditText) TextView mUsernameEditText;
    @BindView(R.id.add) FloatingActionButton mAdd;

    private DatabaseReference billReference;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_fragment);
        ButterKnife.bind(this);
        mUsernameEditText = findViewById(R.id.UsernameEditText);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecylerView.setLayoutManager(linearLayoutManager);
        billReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_BILL);
        billReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                ArrayList<Bill> mbill =new ArrayList<>();

                Toast.makeText(DashboardActivity.this,"successful",Toast.LENGTH_LONG).show();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    mbill.add(postSnapshot.getValue(Bill.class));

                }
                mRecylerView.setAdapter(new BillAdapter(DashboardActivity.this,mbill));


            }

            @Override
            public void onCancelled( DatabaseError error) {
                Toast.makeText(DashboardActivity.this,"error",Toast.LENGTH_LONG).show();

            }
        });

        mProceedButton.setOnClickListener(this);
        mAuth= FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged( FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };

        mProceedButton.setOnClickListener(this);
        mAdd.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                if (v==mProceedButton) {
//                passing data from Dashboard activity
                    Intent intent = new Intent(DashboardActivity.this, PaymentActivity.class);
                    intent.putExtra(" payment","payment");
                    startActivity(intent);
                    onBackPressed();
                }else {
                    if(v==mAdd){
                        Intent intent = new Intent(DashboardActivity.this, AddBill.class);
                        intent.putExtra(" payment","payment");
                        startActivity(intent);
                        onBackPressed();
                    }

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
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
