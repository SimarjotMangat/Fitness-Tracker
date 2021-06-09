package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.grpc.InternalWithLogId;

public class stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        Button stats=(Button)findViewById(R.id.showstatsbutton);
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText day1=(EditText)findViewById(R.id.day1);
                EditText day2=(EditText)findViewById(R.id.day2);
                EditText day3=(EditText)findViewById(R.id.day3);
                EditText day4=(EditText)findViewById(R.id.day4);
                EditText day5=(EditText)findViewById(R.id.day5);
                EditText day6=(EditText)findViewById(R.id.day6);
                EditText day7=(EditText)findViewById(R.id.day7);
               if(!day1.getText().toString().isEmpty()&&!day2.getText().toString().isEmpty()&&
                        !day3.getText().toString().isEmpty()&&!day4.getText().toString().isEmpty()&&!day5.getText().toString().isEmpty()
                        &&!day5.getText().toString().isEmpty()&&!day7.getText().toString().isEmpty())

                {

                    Intent i=new Intent(stats.this,showstats.class);
                    i.putExtra("day1",day1.getText().toString());
                    i.putExtra("day2",day2.getText().toString());
                    i.putExtra("day3",day3.getText().toString());
                    i.putExtra("day4",day4.getText().toString());
                    i.putExtra("day5",day5.getText().toString());
                    i.putExtra("day6",day6.getText().toString());
                    i.putExtra("day7",day7.getText().toString());
                    startActivity(i);





                }
                else{


                    Toast.makeText(getApplicationContext(),"Please enter all the details",Toast.LENGTH_LONG).show();
                }






            }
        });


    }
}