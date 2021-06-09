package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Trainermainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainermainpage);

        Button register =(Button)findViewById(R.id.registeryourself);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Trainermainpage.this,addtrainer.class);
                startActivity(i);
            }
        });

        Button userdata =(Button)findViewById(R.id.userdetails);
        userdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String download_link="https://docs.google.com/spreadsheets/d/1etYJA1u9MykOwnZ1lnVBSV-Nyz7oqhvcMBkccqvjVO0/edit?usp=sharing";

                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(download_link));


                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No application can handle this request Please install a webbrowser",  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }



            }
        });

        Button dietupoad =(Button)findViewById(R.id.dietchart);

        dietupoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Trainermainpage.this,Dietplanupload.class);
                startActivity(i);

            }
        });


    }
}