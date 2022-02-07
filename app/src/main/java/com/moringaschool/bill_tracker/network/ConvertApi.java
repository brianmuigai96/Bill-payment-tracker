package com.moringaschool.bill_tracker.network;

import com.moringaschool.bill_tracker.Data;

import org.json.JSONObject;

import okhttp3.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConvertApi {
   @GET("latest")
    Call<Data> getData();

}
