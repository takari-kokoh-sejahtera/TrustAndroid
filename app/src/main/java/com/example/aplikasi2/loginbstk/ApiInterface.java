package com.example.aplikasi2.loginbstk;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {



    @FormUrlEncoded
    @POST("login.php")
    Call<ResponLogin> MainRequest(
            @Field("username") String username,
            @Field("password") String password
    );

}