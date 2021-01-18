package com.example.rmltest.network;

import com.example.rmltest.model.dekur.DekurUserResponse;
import com.example.rmltest.model.users.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers("Accept: application/json")
    @GET("public-api/users")
    Call<UserResponse> getUserList();

    @Headers("Accept: application/json")
    @GET("partners")
    Call<DekurUserResponse> getDekurUserList();

}
