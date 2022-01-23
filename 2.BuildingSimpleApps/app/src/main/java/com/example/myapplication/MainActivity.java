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

    public void onRegisterBtnClick(View view){
        EditText firstName = findViewById(R.id.edtFirstName);
        EditText lastName = findViewById(R.id.edtLastName);
        EditText email = findViewById(R.id.edtEmail);

        TextView firstNameDisplay = findViewById(R.id.txtViewFirstName);
        TextView lastNameDisplay = findViewById(R.id.txtViewLastName);
        TextView emailDisplay = findViewById(R.id.txtViewEmail);

        firstNameDisplay.setText("First Name: "+firstName.getText().toString());
        lastNameDisplay.setText("Last Name: "+ lastName.getText().toString());
        emailDisplay.setText("Email: "+email.getText().toString());



    }
}