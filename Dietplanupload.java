package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dietplanupload extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietplanupload);
        Button dietplansubmit=(Button)findViewById(R.id.dietupload);
        Button dietplanupload=(Button)findViewById(R.id.trainerupload);
        String download_link="https://forms.gle/8aYMhD8Fu7bcmDGR7";

        dietplanupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(download_link));


                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No application can handle this request Please install a webbrowser",  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });




        dietplansubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dietplanupload.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "Thank you for Uploading  ",  Toast.LENGTH_LONG).show();

                startActivity(i);
            }
        });

    }
}