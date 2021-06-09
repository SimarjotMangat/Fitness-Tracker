package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        Button b=(Button)findViewById(R.id.sendquery);
        Button a=(Button)findViewById(R.id.callus);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:7827220638"));
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText subject=(EditText)findViewById(R.id.subject);
                EditText body1=(EditText)findViewById(R.id.body);
                String mail="lalit.bhardwaj13111998@gmail.com";
                String[] recipients = mail.split(",");
                String subject1 = subject.getText().toString();
                String message = body1.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject1);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("text/plain");
                body1.setText("");
                subject.setText("");

                startActivity(Intent.createChooser(intent,"choose please"));





            }
        });
    }
}