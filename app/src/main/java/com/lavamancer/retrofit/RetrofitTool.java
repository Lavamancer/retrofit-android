package com.lavamancer.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTool {

    public PlaceholderApi api;


    private static RetrofitTool instance;
    private RetrofitTool() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.0.12:8080/")
                .client(createHttpClient())
                .build();

        api = retrofit.create(PlaceholderApi.class);
    }

    private OkHttpClient createHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }

    public static RetrofitTool getInstance() {
        if (instance == null) instance = new RetrofitTool();
        return instance;
    }

}
