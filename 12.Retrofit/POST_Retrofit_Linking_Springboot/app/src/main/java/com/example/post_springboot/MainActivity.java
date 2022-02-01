package com.example.post_springboot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button postBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postBtn = findViewById(R.id.postBtn);

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postFunction();
            }
        });
    }

    public void postFunction(){
        ApiInterface apiInterface = RetrofitClient.GetApiClientSeed().create(ApiInterface.class);

        Call<Person> call = apiInterface.getUserInformation("Andy");
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
//                Toast.makeText(MainActivity.this, response.body().getName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
//        Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
    }
}