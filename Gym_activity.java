package com.example.fitness_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.fitness_tracker.R.id.settings;

public class Gym_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseAuth auth=FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_activity);
        ImageView gif=(ImageView) findViewById(R.id.biceps);
        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gym_activity.this,bicepsworkout.class);
                Log.i("hello","bye");
                startActivity(i);
            }
        });
        ImageView gif2=(ImageView)findViewById(R.id.bmigif);
        gif2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Gym_activity.this,bmi.class);
                startActivity(i);
            }
        });

        ImageView gif4=(ImageView)findViewById(R.id.gif123);
        gif4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Gym_activity.this,trainerlist1.class);
                startActivity(i);

            }
        });

        ImageView im=(ImageView)findViewById(R.id.cardio123);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Gym_activity.this,cardio.class);
                startActivity(i);
            }
        });
        ImageView im1=(ImageView)findViewById(R.id.gifImageView1234);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Gym_activity.this,stats.class);
                startActivity(i);

            }
        });

        ImageView step=(ImageView)findViewById(R.id.stepcounter);
        step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Gym_activity.this,StepActivity.class);
                startActivity(i);
            }
        });
        ImageView back=(ImageView)findViewById(R.id.gifImageView12);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Gym_activity.this,backexercise.class);
                startActivity(i);
            }
        });

        ImageView chest=(ImageView)findViewById(R.id.gifImageView1);
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Gym_activity.this,chestexercise.class);
                startActivity(i);
            }
        });



        NavigationView nav=(NavigationView)findViewById(R.id.navigation);

        androidx.appcompat.widget.Toolbar toolbar;
        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle;
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.Home:
                        String download_link="https://forms.gle/qyxcnWvE954mHeZX8";
                        try {
                            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(download_link));


                            startActivity(myIntent);
                        } catch (ActivityNotFoundException e) {
                            Toast.makeText(getApplicationContext(), "No application can handle this request Please install a webbrowser",  Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);


                        break;

                    case R.id.call:
                        Intent intent=new Intent(Gym_activity.this,contactus.class);

                        startActivity(intent);

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case settings:
                        String download_link1="https://docs.google.com/spreadsheets/d/1ytyJuZfdT9jFK52hodmZ4hckkHBPfNxn-dzkyCj4lCk/edit?usp=sharing";
                        try {
                            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(download_link1));
                            startActivity(myIntent);
                        } catch (ActivityNotFoundException e) {
                            Toast.makeText(getApplicationContext(), "No application can handle this request Please install a webbrowser",  Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;

                    case R.id.logout:
                        auth.signOut();
                        Intent intent1=new Intent(Gym_activity.this,MainActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        startActivity(intent1);






                }



                return true;
            }
        });

        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.red1));










    }



}