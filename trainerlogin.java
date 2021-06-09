package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class trainerlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainerlogin);
        EditText trainerpass=(EditText)findViewById(R.id.tarinerpass);

        Button trainersubmit=(Button)findViewById(R.id.trainersubmit);

        int key=9786;
        trainersubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ab=trainerpass.getText().toString();
                if(trainerpass.getText().toString().isEmpty()||ab==""||ab==" "){
                    Toast.makeText(getApplicationContext(), "Empty Key", Toast.LENGTH_SHORT).show();

                }


                else {
                    int num=Integer.parseInt(ab);
                    if(num==key){
                        trainerpass.setText("");
                        Intent i=new Intent(trainerlogin.this,Trainermainpage.class);
                        startActivity(i);

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Wrong Key", Toast.LENGTH_SHORT).show();

                    }


                }

            }
        });
    }
}