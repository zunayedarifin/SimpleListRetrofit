package com.example.rmltest.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.rmltest.model.UserResponse;
import com.example.rmltest.network.Api;
import com.example.rmltest.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private MutableLiveData<Boolean> isUpdated = new MutableLiveData<>();

    public MutableLiveData<UserResponse> userDetails() {

        MutableLiveData<UserResponse> liveData = new MutableLiveData<>();

        final ApiService apiReader = Api.getOrkoApiService();
        isUpdated.setValue(true);

        Call<UserResponse> list = apiReader.getUserList();

        list.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    liveData.postValue(response.body());
                    isUpdated.setValue(false);

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                isUpdated.setValue(false);

            }
        });

        return liveData;

    }
}
