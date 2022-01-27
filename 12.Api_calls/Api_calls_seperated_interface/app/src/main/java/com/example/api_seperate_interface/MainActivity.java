package com.example.api_seperate_interface;

import static com.example.api_seperate_interface.ApiClient.GetPhotoApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtDisplay = findViewById(R.id.txtName);

//        GetPhotoApi().getFirstPhoto().enqueue(new Callback<Photo>() {
//            @Override
//            public void onResponse(Call<Photo> call, Response<Photo> response) {
//                Toast.makeText(MainActivity.this, response.body().getTitle(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<Photo> call, Throwable t) {
//
//            }
//        });

        GetPhotoApi().getPhotoByNum("2").enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                Toast.makeText(MainActivity.this, response.body().getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {

            }
        });


    }
}