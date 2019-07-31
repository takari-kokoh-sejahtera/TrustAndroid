package com.example.aplikasi2.rest;
import com.example.aplikasi2.config.ServerConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final  String BASE_URL =
            ServerConfig.API_ENDPOINT;
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new
                    Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}
