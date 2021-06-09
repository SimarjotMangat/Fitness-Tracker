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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registerpage extends AppCompatActivity {
    public FirebaseAuth auth;
    EditText e1;
    EditText e2;
    String email = "";
    String pass = "";
    FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        e1 = (EditText)findViewById(R.id.email);
        e2 = (EditText)findViewById(R.id.password1);

        Button b1=(Button)findViewById(R.id.joinnow);

        //create a firebase instance
        mauth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String email1 = e1.getText().toString().trim();
               String pass1 = e2.getText().toString().trim();
                mauth.createUserWithEmailAndPassword(email1, pass1)
                        .addOnCompleteListener(registerpage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("hy", "createUserWithEmail:success");
                                    Log.i("yoi",email);
                                    FirebaseUser user = mauth.getCurrentUser();
                                    Intent i=new Intent(registerpage.this,usercongratsaftersignup.class);
                                    startActivity(i);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("bye", "createUserWithEmail:failure", task.getException());

                                }
                            }
                        });

            }
        });












    }
    //check if user is currently signed in






    }




