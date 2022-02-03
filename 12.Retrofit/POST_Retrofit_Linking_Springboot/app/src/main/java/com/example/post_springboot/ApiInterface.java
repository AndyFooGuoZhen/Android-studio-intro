package com.example.post_springboot;

import org.json.JSONObject;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

//    @FormUrlEncoded
    @POST("/api/v1/person")
    Call<Person> getUserInformation(@Body Person person);
//    Call<Person> getUserInformation(@Body Person person);

    @GET("/api/v1/person")
    Call<List<Person>> retrieveUserInformation();

    @PUT("/api/v1/person/{id}")
    Call<Person> replacePerson(@Path("id") String id, @Body Person person);

}
