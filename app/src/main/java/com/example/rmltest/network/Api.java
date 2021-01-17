package com.example.rmltest.network;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static ApiService mOrkoInstance;
    private Retrofit mRetrofit;


    public static ApiService getOrkoApiService() {
        if (mOrkoInstance == null) {
            mOrkoInstance = getApiService("https://gorest.co.in/");
        }
        return mOrkoInstance;
    }

    public static ApiService getApiService(String baseUrl) {
        return new Api(baseUrl).createService(ApiService.class);
    }

    private <T> T createService(Class<T> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    private Api(String baseUrl) {

       /* Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor).build();


        this.mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
