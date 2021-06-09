package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class backexercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backexercise);

        ArrayList<bicep> arr= new ArrayList<>();
        arr.add(new bicep("Kettle Swings","Place a kettlebell a couple of feet in front of you. Stand with your feet slightly wider than shoulder-width apart and bend your knees to lean forward and grab the handle with both hands",

                R.drawable.kettleswingsback,R.drawable.play));
        arr.add(new bicep("Pull-Up","Grab the handles of the pull-up station with your palms facing away from you and your arms fully extended. Your hands should be around shoulder-width apart.",
                R.drawable.pullupback,R.drawable.play));
        arr.add(new bicep("Inverted Row","Set up a bar in a rack at waist height. Grab it with a wider than shoulder-width overhand grip and hang underneath. Position yourself with heels out in front of you and arms fully extended",
                R.drawable.latpull,R.drawable.play));
        adapter a1=new adapter(this,arr);
        ImageView gif=(ImageView) findViewById(R.id.workout_button);

        ListView li=(ListView) findViewById(R.id.listback);
        li.setAdapter(a1);
    }
}