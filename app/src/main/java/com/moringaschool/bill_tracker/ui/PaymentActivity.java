package com.moringaschool.bill_tracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.network.ConvertApi;

import org.json.JSONObject;

public class PaymentActivity  extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent intent= getIntent();
        String payment = intent.getStringExtra("payment");
        retrofitBuilder = new RetrofitBuilder();

        Retrofit retrofit =retrofitBuilder.getRetrofitBuilder();
        retrofit.create(Data.class);

        call<JSONObject> call =ConvertApi.getRates();

        call.enqueue(new callback<JSONObject>();){
            @Override
             Public void onResponse(Call <JSONObject> call, Response <JSONObject> response){
                if(response.isSuccessful()){
                    Log.d(tag, "json response: ");
                }
            }

        }

    }
}
