package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class listtrainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtrainer);
        Button dietupload=(Button)findViewById(R.id.dietupload1);
        dietupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(listtrainer.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"Registration Completed",Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
}