package com.moringaschool.bill_tracker.retrofit_client;

import com.moringaschool.bill_tracker.network.ConvertApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataClient {
    private static Retrofit retrofit = null;

    public static ConvertApi getClient{
        if(retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest  = chain.request().newBuilder()
                                    .addHeader("API_KEY")
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

             retrofit = new Retrofit.Builder()
                    .baseUrl("https://freecurrencyapi.net/api/v2/")
                     .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.ConvertApi.class);
        }
    }
}
