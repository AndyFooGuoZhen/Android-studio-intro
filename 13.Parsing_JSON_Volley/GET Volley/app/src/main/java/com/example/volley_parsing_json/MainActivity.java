package com.example.volley_parsing_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        Button btn = findViewById(R.id.parseBtn);

        mQueue = Volley.newRequestQueue(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }
        });


    }

    public void jsonParse(){
        String url = "https://jsonplaceholder.typicode.com/posts";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    JSONArray jsonArr = new JSONArray(response.toString());

                    for(int i=0; i< jsonArr.length(); i++)
                    {
                        JSONObject contents = jsonArr.getJSONObject(i);
                        String userId = contents.getString("userId");
//                        Toast.makeText(MainActivity.this, userId, Toast.LENGTH_SHORT).show();
                        txt.append(userId);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                    JSONArray jsonArr = new JSONArray(response.toString());

//                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });

        mQueue.add(request);


    }
}