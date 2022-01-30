package com.example.post_retrofit;

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
                btnPost();
            }
        });
    }

    public void btnPost(){
        ApiInterface apiInterface = RetrofitClient.GetApiClientSeed().create(ApiInterface.class);
        Call<User> call = apiInterface.getUserInformation("Andy","Wassup");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, response.body().getName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, response.body().getJob(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, response.body().getId(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, response.body().getCreatedAt(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}