package com.example.aplikasi2.loginbstk;

import com.example.aplikasi2.Model.Ms_Customers;
import com.example.aplikasi2.Model.Ms_Vehicles;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("users")
    Call<ResponLogin> MainRequest(
            @Field("User_Name") String User_Name,
            @Field("Password") String Password
    );

    @GET("Customer")
    Call<List<Ms_Customers>> GetCustomer();

    @FormUrlEncoded
    @POST("users")
    Call<Ms_Vehicles> GetPlatNo();

}