package com.example.api_calls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtApi = findViewById(R.id.txtView1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi apiClient = retrofit.create(PostApi.class);
        apiClient.getFirstPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                txtApi.setText(response.body().getTitle());
                Post post = new Post();
                post.setId(response.body().getUserId());
                Toast.makeText(MainActivity.this, post.getId() +"", Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, response.body().getUserId() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }
}

interface PostApi{

    @GET("/posts/1")
    Call<Post> getFirstPost();
}

class Post{
    private int userId;

    private int id;
    private String title;

    @SerializedName("body") //tell us precisely what we want from json file
    private String bigTexts;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBigTexts() {
        return bigTexts;
    }

    public void setBigTexts(String bigTexts) {
        this.bigTexts = bigTexts;
    }
}