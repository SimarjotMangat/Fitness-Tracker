package com.example.fitness_tracker;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseAuth auth=FirebaseAuth.getInstance();

        FirebaseUser firebaseuser=auth.getCurrentUser();
        if(firebaseuser!=null){
            Intent i=new Intent(Home.this,Gym_activity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(i);
        }



    }





}
