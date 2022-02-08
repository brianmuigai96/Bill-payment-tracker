package com.moringaschool.bill_tracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.bill_tracker.Constants;

import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.models.Data;
import com.moringaschool.bill_tracker.network.ConvertApi;
import com.moringaschool.bill_tracker.retrofit_client.DataClient;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity  extends AppCompatActivity {
    ConvertApi convertApi;
    Button button;
    EditText currencyToBeConverted;
    EditText currencyConverted;
    Spinner convertToDropdown;
    Spinner convertFromDropdown;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent intent= getIntent();
        String payment = intent.getStringExtra("payment");

//        Initialization
        currencyConverted = (EditText) findViewById(R.id.currency_converted);
        currencyToBeConverted = (EditText) findViewById(R.id.currency_to_be_converted);
        convertToDropdown = (Spinner) findViewById(R.id.convert_to);
        convertFromDropdown = (Spinner) findViewById(R.id.convert_from);
        button = (Button) findViewById(R.id.button);

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

