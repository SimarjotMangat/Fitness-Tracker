package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class calculate_bmi extends AppCompatActivity {
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
        //take the intent
        Intent i=getIntent();
        String ab=i.getStringExtra("bmi");
        String name=i.getStringExtra("bminame");
        String ab1=ab.toString();
        Double val=Double.parseDouble(ab1);
        TextView t1=(TextView) findViewById(R.id.bmicount);
        TextView t2=(TextView)findViewById(R.id.bmicategory);
        ImageView im=(ImageView)findViewById(R.id.bmiimage);
        if(val<18.50){
            t1.setText(""+ab1);
            t2.setText("UnderWeight! Please "+ name+ " Eat Something");
            im.setImageResource(R.drawable.underweight);
            url="https://uccs.edu/healthcircle/sites/healthcircle/files/inline-files/Weight%20Gain.pdf";


        }
        else if(val>=18.50&&val<=25.50){
            t1.setText(""+ab1);
            t2.setText("Perfect Shape "+name);
            im.setImageResource(R.drawable.runningman);
            url="https://pdfdrivefiles.files.wordpress.com/2021/02/diet-chart-final1600.pdf";



        }
        else{
            t1.setText(""+ab1);
            t2.setText("Please !Exercise "+ name);
            im.setImageResource(R.drawable.obese);
            url="https://pdfdrivefiles.files.wordpress.com/2021/02/diet-chart-final1600.pdf";



        }
        Button b1=(Button)findViewById(R.id.download);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse(url);
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);


            }
        });







    }
}