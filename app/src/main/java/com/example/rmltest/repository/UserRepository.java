package com.example.rmltest.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.rmltest.model.dekur.DekurUserResponse;
import com.example.rmltest.model.users.UserResponse;
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

    public MutableLiveData<DekurUserResponse> dekurUserDetails() {

        MutableLiveData<DekurUserResponse> liveData = new MutableLiveData<>();

        final ApiService apiReader = Api.getOrkoApiService(1);
        isUpdated.setValue(true);

        Call<DekurUserResponse> list = apiReader.getDekurUserList();

        list.enqueue(new Callback<DekurUserResponse>() {
            @Override
            public void onResponse(Call<DekurUserResponse> call, Response<DekurUserResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    liveData.postValue(response.body());
                    isUpdated.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<DekurUserResponse> call, Throwable t) {
                isUpdated.setValue(false);

            }
        });

        return liveData;

    }
}
