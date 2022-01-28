package com.example.ui_basics_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox checkBoxHarry, checkBoxBla, checkBoxWoo;
    private RadioButton start,stop;
    private RadioGroup group;
    private ProgressBar bar;

    @Override
    public void onCheckedChanged( CompoundButton compoundButton, boolean isChecked){
        if(isChecked){
                    Toast.makeText(MainActivity.this, "You like watching harry potter", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "You dont like watching harry potter", Toast.LENGTH_SHORT).show();
                }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHarry = findViewById(R.id.checkBoxHarry);
        checkBoxBla = findViewById(R.id.checkBoxBla);
        checkBoxWoo = findViewById(R.id.checkBoxWoo);
        checkBoxHarry.setOnCheckedChangeListener(this);
        group=findViewById(R.id.RadioGroupss);
        bar=findViewById(R.id.progressb);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch(id){
                    case R.id.startradio:
                        Toast.makeText(MainActivity.this, "Starting app", Toast.LENGTH_SHORT).show();
                        bar.setVisibility(View.VISIBLE);
                        break;

                    case R.id.stopradio:
                        Toast.makeText(MainActivity.this, "Stopping app", Toast.LENGTH_SHORT).show();
                        bar.setVisibility(View.INVISIBLE);

                    default:
                        break;
                }
            }
        });


//        start = findViewById(R.id.startradio);
//        stop=findViewById(R.id.stopradio);

//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Starting", Toast.LENGTH_SHORT).show();
//            }
//        });


//        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if(isChecked){
//                    Toast.makeText(MainActivity.this, "You like watching harry potter", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(MainActivity.this, "You dont like watching harry potter", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }
}