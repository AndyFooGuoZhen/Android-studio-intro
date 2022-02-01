package com.example.post_springboot;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    static Retrofit apiClientSeed = null;

    static Retrofit GetApiClientSeed() {
        if (apiClientSeed == null) {
            apiClientSeed = new Retrofit.Builder()
                    .baseUrl(" http://10.0.2.2:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return apiClientSeed;
    }
}
