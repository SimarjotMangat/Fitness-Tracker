package com.example.fitness_tracker;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class bmi extends AppCompatActivity {
    EditText height;
    EditText weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        RadioButton r1=(RadioButton)findViewById(R.id.radio1);
        RadioButton r2=(RadioButton)findViewById(R.id.radio2);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1.setChecked(true);
                r2.setChecked(false);

            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1.setChecked(false);
                r2.setChecked(true);

            }
        });
        Button b1=(Button)findViewById(R.id.bmi_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText e1=(EditText)findViewById(R.id.bminame);
                height=(EditText)findViewById(R.id.height);
                String h1=height.getText().toString();
                weight=(EditText)findViewById(R.id.weight);
                EditText age=(EditText)findViewById(R.id.ageofuser);
                String w1=weight.getText().toString();
                if(!e1.getText().toString().isEmpty()&&!h1.isEmpty()&&!w1.isEmpty()&&!age.getText().toString().isEmpty()){

                    double height2=Integer.parseInt(h1);
                    double meter=height2/100;
                    double weight2=Integer.parseInt(w1);
                    double bmi=weight2/(meter*2);
                    double roundOff = Math.round(bmi * 100.0) / 100.0;
                    String hello=Double.toString(roundOff);
                    Intent i=new Intent(bmi.this,calculate_bmi.class);

                    i.putExtra("bmi",hello);
                    i.putExtra("bminame",e1.getText().toString());

                    startActivity(i);





                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill all the details",Toast.LENGTH_LONG).show();
                }







            }
        });

    }
}