package com.example.retrofitandrxandroid.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static final String BASE_URL="https://simplifiedcoding.net/demos/";

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static APIservice getAPIservice(){
        return getRetrofit().create(APIservice.class);
    }

}
