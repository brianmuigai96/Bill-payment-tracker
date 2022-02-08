package com.moringaschool.bill_tracker.network;



import com.moringaschool.bill_tracker.models.Data;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConvertApi {
   @GET("latest")
   Call<Data> getData(@Query("apikey")String apikey);

}
