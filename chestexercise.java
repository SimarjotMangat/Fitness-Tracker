package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class chestexercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestexercise);
        ArrayList<bicep> arr= new ArrayList<>();
        arr.add(new bicep("Arnold chest press","Start by lying flat on a bench holding a dumbbell in each hand, pressed directly overhead with your palms facing towards your feet. Lower the weights down towards the chest while rotating your wrists clockwise",

                R.drawable.arnoldchestpress,R.drawable.play));
        arr.add(new bicep("Chest dip","While keeping your feet on the ground, grasp the bars and lock out your arms until you've found a comfortable starting position. Then, lift your legs off the ground and lean slightly forward.",
                R.drawable.chestdip,R.drawable.play));
        arr.add(new bicep("Svend press"," Start standing with your feet at shoulder-width distance, shoulders back, and two five-pound plates pressed against one another at chest height. Inhale, then press the plates directly out in front of you. ",
                R.drawable.sevendpress,R.drawable.play));
        adapter a1=new adapter(this,arr);
        ImageView gif=(ImageView) findViewById(R.id.workout_button);

        ListView li=(ListView) findViewById(R.id.listchest);
        li.setAdapter(a1);
    }
}