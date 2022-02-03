package com.example.post_springboot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button postBtn;
    private Button getBtn;
    private Button putBtn;

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

        getBtn = findViewById(R.id.getBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFunction();
            }
        });

        putBtn = findViewById(R.id.putBtn);
        putBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putFunction();
            }
        });
    }

    public void postFunction(){
        ApiInterface apiInterface = RetrofitClient.GetApiClientSeed().create(ApiInterface.class);
         Person person1 = new Person("John");

        Call<Person> call = apiInterface.getUserInformation(person1);

        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getFunction(){
        ApiInterface apiInterface = RetrofitClient.GetApiClientSeed().create(ApiInterface.class);
        Call<List<Person>> call = apiInterface.retrieveUserInformation();

        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {

                for(int i=0; i<response.body().size(); i++)
                {
                    Toast.makeText(MainActivity.this, response.body().get(i).getName(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void putFunction() {
        ApiInterface apiInterface = RetrofitClient.GetApiClientSeed().create(ApiInterface.class);
        Person person1 = new Person("Miami");

        Call<Person> call = apiInterface.replacePerson("1d0fdcdd-a206-4b8c-bf5c-6d49d3b48ea1", person1);

        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}