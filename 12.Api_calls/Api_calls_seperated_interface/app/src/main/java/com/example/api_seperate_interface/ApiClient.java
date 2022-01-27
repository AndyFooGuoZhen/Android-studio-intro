package com.example.api_seperate_interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    static Retrofit apiClientSeed = null;

    static Retrofit GetApiClientSeed(){
        if(apiClientSeed ==null){
            apiClientSeed = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return apiClientSeed;
    }

    public static PhotoApi GetPhotoApi(){
        return GetApiClientSeed().create(PhotoApi.class);
    }

}
