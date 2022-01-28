package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void  onBtnClick(View view){
        TextView txt_Hello = findViewById(R.id.textMessage);
        EditText editText = findViewById(R.id.edT);
        String name = editText.getText().toString();
        txt_Hello.setText(name);  //Sets the text to hello
    }
}