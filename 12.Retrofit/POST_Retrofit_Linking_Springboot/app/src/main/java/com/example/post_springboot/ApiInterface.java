package com.example.post_springboot;

import org.json.JSONObject;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

//    @FormUrlEncoded
    @POST("/api/v1/person")
    Call<Person> getUserInformation(@Body Person person);
//    Call<Person> getUserInformation(@Body Person person);
}
