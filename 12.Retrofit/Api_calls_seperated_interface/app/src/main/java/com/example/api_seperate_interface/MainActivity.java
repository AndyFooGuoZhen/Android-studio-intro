package com.example.api_seperate_interface;

import static com.example.api_seperate_interface.ApiClient.GetPhotoApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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

//        GetPhotoApi().getPhotoByNum("2").enqueue(new Callback<Photo>() {
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

        GetPhotoApi().getPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {

                for(int i=0; i< response.body().size(); i++)
                {
                    Toast.makeText(MainActivity.this, response.body().get(i).getTitle(), Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(MainActivity.this, response.body().get(0).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });




    }
}