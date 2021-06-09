package com.example.fitness_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
EditText t1;
EditText t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.login);
         t1=(EditText)findViewById(R.id.user);
         t2=(EditText)findViewById(R.id.password);
       // EditText phone=(EditText)findViewById(R.id.phoneno);
        //String phoneno=phone.getEditableText().toString();
        //Log.i("hello",phoneno);

//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(t1.getText().toString().equals("admin")&&t2.getText().toString().equals("1234")){
//                    Intent i=new Intent(MainActivity.this,Gym_activity.class);
//                    Log.i("hello","bye");
//                    startActivity(i);
//                }
//                else {
//                    Toast.makeText(getApplicationContext(),"Wrong_password",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
         FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        TextView t=(TextView)findViewById(R.id.register);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,registerpage.class);
                startActivity(i);

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=t1.getText().toString().trim();
                String password=t2.getText().toString().trim();
                if(email.isEmpty()&&password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter Your email and password",
                            Toast.LENGTH_SHORT).show();

                }
                else if(!email.isEmpty()&&password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter Your  password",
                            Toast.LENGTH_SHORT).show();

                }
                else if(email.isEmpty() && !password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter Your email ",
                            Toast.LENGTH_SHORT).show();

                }
                else{
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override


                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        t1.setText("");
                                        t2.setText("");
                                        Intent i=new Intent(MainActivity.this,Gym_activity.class);
                                        startActivity(i);
                                        // Sign in success, update UI with the signed-in user's information

                                    } else {
                                        // If sign in fails, display a message to the user.

                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();




                                    }
                                }
                            });


                }

            }
        });


        Button registeruser=(Button)findViewById(R.id.register12);

        registeruser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,trainerlogin.class);
                startActivity(i);

            }
        });

    }

}
