package com.example.aplikasi2.loginbstk;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {



    @FormUrlEncoded
    @POST("users")
    Call<ResponLogin> MainRequest(
            @Field("User_Name") String User_Name,
            @Field("Password") String Password
    );

}