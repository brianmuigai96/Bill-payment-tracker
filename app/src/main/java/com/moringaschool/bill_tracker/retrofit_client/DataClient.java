package com.moringaschool.bill_tracker.retrofit_client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataClient {
    private static Retrofit retrofit = null;

    public static ConvertApi getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://freecurrencyapi.net/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit.create(ConvertApi.class);
    }

}

