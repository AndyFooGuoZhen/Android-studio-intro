package com.example.post_springboot;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/api/v1/person")
    Call<Person> getUserInformation(@Field("name") String name);
}
