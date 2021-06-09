package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class bicepsworkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicepsworkout);
        ArrayList<bicep> arr= new ArrayList<>();
        arr.add(new bicep("BicepCurls","  Stand holding a dumbbell in each hand with your arms hanging by your sides. Ensure your elbows are close to your torso and your palms facing forward. Keeping your upper arms stationary, exhale as you curl the weights up to shoulder level while contracting your biceps",

                R.drawable.dumbelcurl1,R.drawable.play));
        arr.add(new bicep("BarbellCurl","Stand tall with your chest up and core braced, holding the barbell with your hands just outside of your hips, using an underhand grip. Keeping your chest up and your elbows tight to your sides, initiate the move by raising your hands slightly so you feel your biceps become engaged",
                R.drawable.barbellcurl,R.drawable.play));
        arr.add(new bicep("InclineCurls","Sit down against the workout bench, keeping your back straight and your abdominal muscles tight. Your weights should be at your sides to start, one in each hand.\n" +
                "When you’ve gotten the starting position down, lift each dumbbell, palms up, toward your shoulders. It’s important to keep your upper arms tight so that you can isolate the biceps brachii muscle as you move your lower arms only",
                R.drawable.incline,R.drawable.play));
        adapter a1=new adapter(this,arr);
        ImageView gif=(ImageView) findViewById(R.id.workout_button);

        ListView li=(ListView) findViewById(R.id.list);
        li.setAdapter(a1);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //As you are using Default String Adapter
                Intent i=new Intent(bicepsworkout.this,stepsexercise.class);
                i.putExtra("gym",arr.get(position).heading);
                String a=arr.get(position).heading;
                Log.i("hy",a);
                startActivity(i);
            }
        });







    }

}