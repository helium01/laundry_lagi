package com.opencv.laundrylagi.app.model.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers
import retrofit2.http.POST;

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("login")
    fun login(
        @Body request: userRequest
    ): Call<userResponse>

    @Headers("Content-Type: application/json")
    @POST("register")
    fun register(
        @Body request: registerRequest
    ): Call<userResponse>
}
