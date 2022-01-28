package com.example.ui_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button2:
                Log.d("Message", "button2");
                Toast.makeText(this, "button2", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextView text = findViewById(R.id.txtWelcome);
//                text.setText("Hello World");
//            }
//        });
    }

    public void onHelloBtnCLicked(View view){
        TextView text = findViewById(R.id.txtWelcome);
        text.setText("Bye");
    }
}