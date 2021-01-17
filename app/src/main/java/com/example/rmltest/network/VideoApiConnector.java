package com.example.rmltest.network;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoApiConnector {

    private static ApiService mOrkoInstance;
    private Retrofit mRetrofit;


    public static ApiService getService() {
        if (mOrkoInstance == null) {
            mOrkoInstance = getApiService("https://gorest.co.in/");
        }
        return mOrkoInstance;
    }

    public static ApiService getApiService(String baseUrl) {
        return new VideoApiConnector(baseUrl).createService(ApiService.class);
    }

    private <T> T createService(Class<T> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    private VideoApiConnector(String baseUrl) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        this.mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
