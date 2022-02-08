package com.moringaschool.bill_tracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.bill_tracker.Constants;
import com.moringaschool.bill_tracker.Data;
import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.network.ConvertApi;
import com.moringaschool.bill_tracker.retrofit_client.DataClient;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity  extends AppCompatActivity {
    ConvertApi convertApi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent intent= getIntent();
        String payment = intent.getStringExtra("payment");

        convertApi = DataClient.getClient();
        Call<Data> call =convertApi.getData(Constants.API_KEY);
       call.enqueue(new Callback<Data>() {
           @Override
           public void onResponse(Call<Data> call, Response<Data> response) {




           }

         @Override
           public void onFailure(Call<Data> call, Throwable t) {

           }
       });


    }












    }

