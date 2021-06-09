package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class stepsexercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int stop=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepsexercise);
        Intent i=getIntent();
        String ab=i.getStringExtra("gym");
        Spinner spinner=(Spinner)findViewById(R.id.choosetimer);
        Button button=(Button)findViewById(R.id.workoutstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timer= (String) spinner.getSelectedItem();
                String image=ab;
                Intent i=new Intent(stepsexercise.this,bicepworkout2.class);
                i.putExtra("image",image);
                i.putExtra("timer",timer);
                startActivity(i);
            }
        });
    }
}